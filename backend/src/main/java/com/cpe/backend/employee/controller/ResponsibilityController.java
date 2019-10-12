package com.cpe.backend.employee.controller;

import com.cpe.backend.employee.entity.Responsibility;
import com.cpe.backend.employee.repository.ResponsibilityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class ResponsibilityController {

    @Autowired
    private final ResponsibilityRepository responsibilityRepository;

    public ResponsibilityController(ResponsibilityRepository responsibilityRepository) {
        this.responsibilityRepository = responsibilityRepository;
    }

    @GetMapping("/responsibility")
    public Collection<Responsibility> Responsibility() {
        return responsibilityRepository.findAll().stream().collect(Collectors.toList());
    }

}