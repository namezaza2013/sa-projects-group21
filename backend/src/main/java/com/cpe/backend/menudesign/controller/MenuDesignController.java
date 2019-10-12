package com.cpe.backend.menudesign.controller;
import com.cpe.backend.menudesign.entity.FoodImage;
import com.cpe.backend.menudesign.entity.FoodTechinque;
import com.cpe.backend.menudesign.entity.*;
import com.cpe.backend.menudesign.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.cpe.backend.menudesign.model.*;

import com.cpe.backend.menu.entity.*;
import com.cpe.backend.menu.repository.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class MenuDesignController {
    @Autowired
    private final MenuDesignRepository menuDesignRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private FoodImageRepository foodImageRepository;
    @Autowired
    private FoodTechinqueRepository foodTechinqueRepository;

    MenuDesignController(MenuDesignRepository menuDesignRepository, MenuRepository menuRepository,
            FoodImageRepository foodImageRepository, FoodTechinqueRepository foodTechinqueRepository) {
        this.menuDesignRepository = menuDesignRepository;
        this.menuRepository = menuRepository;
        this.foodImageRepository = foodImageRepository;
        this.foodTechinqueRepository = foodTechinqueRepository;
    }

    @GetMapping("/menuDesign")
    public Collection<MenuDesign> MenuDesign() {
        return menuDesignRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/menuDesign/{menuId}/{foodImageId}/{foodTechinqueId}/{desc}")
    public MenuDesign newMenuDesign(MenuDesign newMenuDesign, @PathVariable long menuId,
            @PathVariable long foodTechinqueId, @PathVariable long foodImageId, @PathVariable String desc) {

        Menu menu = menuRepository.findById(menuId).get();
        FoodTechinque foodTechinque = foodTechinqueRepository.findById(foodTechinqueId);
        FoodImage foodImage = foodImageRepository.findById(foodImageId);

        newMenuDesign.setMenu(menu);
        newMenuDesign.setFoodTechinque(foodTechinque);
        newMenuDesign.setFoodImage(foodImage);
        newMenuDesign.setDesciption(desc);
        return menuDesignRepository.save(newMenuDesign); // บันทึก Objcet ชื่อ MenuDesign
    }

    @PostMapping("/menuDesignWithURL")
    @ResponseBody
    public MenuDesign newMenuDesign(@RequestBody MenuDesignBody menuBody)
    {

        FoodImage foodImage = new FoodImage();
        foodImage.setNameImage(menuBody.nameImage);
        foodImage.setUrlImage(menuBody.urlImage);
        foodImageRepository.save(foodImage);

        Menu menu = menuRepository.findById(menuBody.menuId).get();
        FoodTechinque foodTechinque = foodTechinqueRepository.findById(menuBody.foodTechinqueId);

        MenuDesign newMenuDesign = new MenuDesign();
        newMenuDesign.setMenu(menu);
        newMenuDesign.setFoodTechinque(foodTechinque);
        newMenuDesign.setDesciption(menuBody.desc);
        newMenuDesign.setFoodImage(foodImage);
        return menuDesignRepository.save(newMenuDesign); // บันทึก Objcet ชื่อ MenuDesign
    }

}