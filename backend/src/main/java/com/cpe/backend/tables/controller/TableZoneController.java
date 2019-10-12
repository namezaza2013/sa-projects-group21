package com.cpe.backend.tables.controller;

import com.cpe.backend.tables.entity.TableZone;
import com.cpe.backend.tables.repository.TableZoneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.stream.Collectors;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TableZoneController {

    @Autowired
    private final TableZoneRepository tableZoneRepository;

    public TableZoneController(TableZoneRepository tableZoneRepository) {
        this.tableZoneRepository = tableZoneRepository;
    }

    @GetMapping("/tableZone")
    public Collection<TableZone> tableZone() {
        return tableZoneRepository.findAll().stream().collect(Collectors.toList());
    }

}