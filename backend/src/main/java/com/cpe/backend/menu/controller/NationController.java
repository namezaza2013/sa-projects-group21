package com.cpe.backend.menu.controller;

import com.cpe.backend.menu.entity.Nation;
import com.cpe.backend.menu.repository.NationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class NationController {

    @Autowired
    private final NationRepository nationRepository;

    public NationController(NationRepository nationRepository) {
        this.nationRepository = nationRepository;
    }

    @GetMapping("/nation")
    public Collection<Nation> Nation() {
        return nationRepository.findAll().stream().collect(Collectors.toList());
    }

}