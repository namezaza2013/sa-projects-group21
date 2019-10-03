package com.cpe.backend.controller;


import java.util.Collection;
import java.util.stream.Collectors;

import com.cpe.backend.entity.Appropriation;
import com.cpe.backend.repository.AppropriationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class AppropriationController {

    @Autowired
    private final AppropriationRepository appropriationRepository;

    public AppropriationController(AppropriationRepository appropriationRepository) {
        this.appropriationRepository = appropriationRepository;
    }

    @GetMapping("/Appropriation")
    public Collection<Appropriation> Appropriation() {
        return appropriationRepository.findAll().stream().collect(Collectors.toList());
    }

}