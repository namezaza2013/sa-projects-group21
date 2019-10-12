package com.cpe.backend.tables.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.stream.Collectors;

import com.cpe.backend.tables.entity.TableStatus;
import com.cpe.backend.tables.entity.Tables;
import com.cpe.backend.tables.entity.TableType;
import com.cpe.backend.tables.entity.TableZone;
import com.cpe.backend.tables.repository.TableStatusRepository;
import com.cpe.backend.tables.repository.TablesRepository;
import com.cpe.backend.tables.repository.TableTypeRepository;
import com.cpe.backend.tables.repository.TableZoneRepository;



@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TablesController {
    @Autowired
    private final TablesRepository tablesRepository;
    @Autowired
    private TableStatusRepository tableStatusRepository;
    @Autowired
    private TableTypeRepository tableTypeRepository;
    @Autowired
    private TableZoneRepository tableZoneRepository;

    TablesController(TablesRepository tablesRepository, TableStatusRepository tableStatusRepository, TableTypeRepository tableTypeRepository, TableZoneRepository tableZoneRepository) {
        this.tablesRepository = tablesRepository;
        this.tableStatusRepository = tableStatusRepository;
        this.tableTypeRepository = tableTypeRepository;
        this.tableZoneRepository = tableZoneRepository;
    }

    @GetMapping("/tables")
    public Collection<Tables> Tables() {
        return tablesRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/tables/{tableType_id}/{tableZone_id}/{tablesName}/{seat}/{tableStatus_id}")
    public Tables newTable (Tables newTable,
    @PathVariable long tableType_id,
    @PathVariable long tableZone_id,
    @PathVariable String tablesName,
    @PathVariable Integer seat,
    @PathVariable long tableStatus_id){

    TableType tableType = tableTypeRepository.findById(tableType_id);
    TableZone tableZone = tableZoneRepository.findById(tableZone_id);
    TableStatus tableStatus = tableStatusRepository.findById(tableStatus_id);

    newTable.setTableType(tableType);
    newTable.setTableZone(tableZone);
    newTable.setTablesName(tablesName);
    newTable.setSeat(seat);
    newTable.setTableStatus(tableStatus);
    
    return tablesRepository.save(newTable); 
    }
}