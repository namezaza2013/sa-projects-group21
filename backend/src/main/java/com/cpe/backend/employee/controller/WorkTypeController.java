package com.cpe.backend.employee.controller;

import com.cpe.backend.employee.entity.WorkType;
import com.cpe.backend.employee.repository.WorkTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class WorkTypeController {

    @Autowired
    private final WorkTypeRepository worktypeRepository;

    public WorkTypeController(WorkTypeRepository worktypeRepository) {
        this.worktypeRepository = worktypeRepository;
    }

    @GetMapping("/worktype")
    public Collection<WorkType> WorkTypes() {
        return worktypeRepository.findAll().stream().collect(Collectors.toList());
    }

}