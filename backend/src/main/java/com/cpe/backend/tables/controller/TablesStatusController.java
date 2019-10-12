package com.cpe.backend.tables.controller;

import com.cpe.backend.tables.entity.TableStatus;
import com.cpe.backend.tables.repository.TableStatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.stream.Collectors;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TablesStatusController {

    @Autowired
    private final TableStatusRepository tableStatusRepository;

    public TablesStatusController(TableStatusRepository tableStatusRepository) {
        this.tableStatusRepository = tableStatusRepository;
    }

    @GetMapping("/tableStatus")
    public Collection<TableStatus> tableStatus() {
        return tableStatusRepository.findAll().stream().collect(Collectors.toList());
    }

}