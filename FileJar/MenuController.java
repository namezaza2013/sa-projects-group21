package com.cpe.backend.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.net.URLDecoder;

import com.cpe.backend.entity.*;
import com.cpe.backend.repository.*;

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
    private final AppropriationRepository appropriationRepository;
    @Autowired
    private final AppropriateRepository appropriateRepository;

    MenuController(MenuRepository menuRepository,MenuTypeRepository menuTypeRepository,NationRepository nationRepository,AppropriationRepository appropriationRepository,AppropriateRepository appropriateRepository) {
        this.menuRepository = menuRepository;
        this.menuTypeRepository = menuTypeRepository;
        this.nationRepository = nationRepository;
        this.appropriationRepository = appropriationRepository;
        this.appropriateRepository = appropriateRepository;
    }

    @GetMapping("/Menu")
    public Collection<Menu> getMenus() {
        return menuRepository.findAll().stream().collect(Collectors.toList());
    }

    // @PostMapping("/menu/{menuName}/{menuType}/{nation}/{appropriation}/{prices}/{units}")
    // public Menu newMenu(Menu newMenu,
    // @PathVariable long menuTypId,
    // @PathVariable long nationId,
    // @PathVariable long appropriationId,

    // @PathVariable String menuName,
    // @PathVariable Integer menuPrice,
    // @PathVariable Integer menuUnits) {
  

    //     newMenu.setAppropriation(appropriationRepository.findById(appropriationId));
    //     newMenu.setNation(nationRepository.findById(nationId));
    //     newMenu.setMenuType(menuTypeRepository.findById(menuTypId));

    //     newMenu.setMenuName(menuName);
    //     newMenu.setMenuPrice(menuPrice);
    //     newMenu.setMenuUnits(menuUnits);
    //     return menuRepository.save(newMenu);

    // }

}