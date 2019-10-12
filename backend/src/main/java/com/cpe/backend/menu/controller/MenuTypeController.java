
package com.cpe.backend.menu.controller;

import com.cpe.backend.menu.entity.MenuType;
import com.cpe.backend.menu.repository.MenuTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class MenuTypeController {

    @Autowired
    private final MenuTypeRepository menuTypeRepository;

    public MenuTypeController(MenuTypeRepository menuTypeRepository) {
        this.menuTypeRepository = menuTypeRepository;
    }

    @GetMapping("/menuType")
    public Collection<MenuType> Employees() {
        return menuTypeRepository.findAll().stream().collect(Collectors.toList());
    }

}