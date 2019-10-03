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

    MenuController(MenuRepository menuRepository,MenuTypeRepository menuTypeRepository,NationRepository nationRepository,AppropriationRepository appropriationRepository) {
        this.menuRepository = menuRepository;
        this.menuTypeRepository = menuTypeRepository;
        this.nationRepository = nationRepository;
        this.appropriationRepository = appropriationRepository;
    }

    @GetMapping("/Menu")
    public Collection<Menu> getMenus() {
        return menuRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/menus/{menuName}/{menuType}/{nation}/{appropriation}/{prices}/{units}")
    public Menu newMenu(Menu newMenu,
    @PathVariable long menuTypeID,
    @PathVariable long nationID,
    @PathVariable long appropriationID,

    @PathVariable String menuName,
    @PathVariable Integer menuPrice,
    @PathVariable Integer menuUnits) {
        
        // String[] arr = appropriationID.split(",",10);
        // Collection<Appropriation> appro = null;
        // for(String a : arr){
        //     Appropriation appr = appropriationRepository.findById(Long.parseLong(a));
        //     appro.add(appr);
        // };

        // String[] menuTypeArr = menuType.split(",",10);
        // Collection<MenuType> menuTypes = null;
        // for(String a : menuTypeArr){
        //     menuTypes.add(menuTypeRepository.findById(Long.parseLong(a)));
        // };

        newMenu.setAppropriationId(appropriationRepository.findById(appropriationID));
        newMenu.setNationId(nationRepository.findById(nationID));
        newMenu.setMenuTypeID(menuTypeRepository.findById(menuTypeID));
        
        newMenu.setMenuName(menuName);
        newMenu.setMenuPrice(menuPrice);
        newMenu.setMenuUnits(menuUnits);

        return menuRepository.save(newMenu);

    }

}