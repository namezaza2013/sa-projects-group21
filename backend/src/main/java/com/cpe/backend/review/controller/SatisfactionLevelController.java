package com.cpe.backend.review.controller;

import com.cpe.backend.review.entity.SatisfactionLevel;
import com.cpe.backend.review.repository.SatisfactionLevelRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class SatisfactionLevelController {

    @Autowired
    private final SatisfactionLevelRepository satisfactionLevelRepository;

    public SatisfactionLevelController(SatisfactionLevelRepository satisfactionLevelRepository) {
        this.satisfactionLevelRepository = satisfactionLevelRepository;
    }

    @GetMapping("/satisfactionLevel")
    public Collection<SatisfactionLevel> SatisfactionLevels() {
        return satisfactionLevelRepository.findAll().stream().collect(Collectors.toList());
    }

}