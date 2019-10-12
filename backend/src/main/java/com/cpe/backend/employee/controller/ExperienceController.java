package com.cpe.backend.employee.controller;

import com.cpe.backend.employee.entity.Experience;
import com.cpe.backend.employee.repository.ExperienceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class ExperienceController {

    @Autowired
    private final ExperienceRepository experienceRepository;

    public ExperienceController(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @GetMapping("/experience")
    public Collection<Experience> Experience() {
        return experienceRepository.findAll().stream().collect(Collectors.toList());
    }

}