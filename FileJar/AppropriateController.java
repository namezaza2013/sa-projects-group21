package com.cpe.backend.controller;


import java.util.Collection;
import java.util.stream.Collectors;

import com.cpe.backend.entity.*;
import com.cpe.backend.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class AppropriateController {

    @Autowired
    private final AppropriateRepository appropriateRepository;

    public AppropriateController(AppropriateRepository appropriateRepository) {
        this.appropriateRepository = appropriateRepository;
    }

    @GetMapping("/Appropriate")
    public Collection<Appropriate> appropriates() {
        return appropriateRepository.findAll().stream().collect(Collectors.toList());
    }

}