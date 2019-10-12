package com.cpe.backend.tables.controller;

import com.cpe.backend.tables.entity.TableType;
import com.cpe.backend.tables.repository.TableTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.stream.Collectors;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TableTypeController {

    @Autowired
    private final TableTypeRepository tableTypeRepository;

    public TableTypeController(TableTypeRepository tableTypeRepository) {
        this.tableTypeRepository = tableTypeRepository;
    }

    @GetMapping("/tableType")
    public Collection<TableType> TableType() {
        return tableTypeRepository.findAll().stream().collect(Collectors.toList());
    }

}