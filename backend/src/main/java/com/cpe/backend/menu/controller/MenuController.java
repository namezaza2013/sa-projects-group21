package com.cpe.backend.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

import com.cpe.backend.menu.entity.*;
import com.cpe.backend.menu.repository.*;
import com.cpe.backend.menu.model.*;

import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class MenuController {

    @Autowired
    private final MenuRepository menuRepository;
    @Autowired
    private final MenuTypeRepository menuTypeRepository;
    @Autowired
    private final NationRepository nationRepository;
    @Autowired
    private final AppropriateRepository appropriateRepository;

    MenuController(MenuRepository menuRepository,MenuTypeRepository menuTypeRepository,NationRepository nationRepository,AppropriateRepository appropriateRepository) {
        this.menuRepository = menuRepository;
        this.menuTypeRepository = menuTypeRepository;
        this.nationRepository = nationRepository;
        this.appropriateRepository = appropriateRepository;
    }

    @GetMapping("/menu")
    public Collection<Menu> getMenus() {
        return menuRepository.findAll().stream().collect(Collectors.toList());
    }

    
    @PostMapping("/menu")
    public Menu index(Menu newMenu,@RequestBody BodyMenu bodyMenu) {

        newMenu.setMenuTypeID(menuTypeRepository.findById(bodyMenu.menuTypeId).get());
        newMenu.setNationID(nationRepository.findById(bodyMenu.nationId).get());
        newMenu.setAppropriateID(appropriateRepository.findById(bodyMenu.appropriateId).get());

        newMenu.setMenuName(bodyMenu.menuName);
        newMenu.setMenuPrice(bodyMenu.menuPrice);
        newMenu.setMenuUnits(bodyMenu.menuUnits);
        return menuRepository.save(newMenu);
    }

}