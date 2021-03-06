package com.cpe.backend.review.controller;

import com.cpe.backend.review.entity.ImprovementType;
import com.cpe.backend.review.repository.ImprovementTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class ImprovementTypeController {

    @Autowired
    private final ImprovementTypeRepository improvementTypeRepository;

    public ImprovementTypeController(ImprovementTypeRepository improvementTypeRepository) {
        this.improvementTypeRepository = improvementTypeRepository;
    }

    @GetMapping("/improvementType")
    public Collection<ImprovementType> ImprovementType() {
        return improvementTypeRepository.findAll().stream().collect(Collectors.toList());
    }

}