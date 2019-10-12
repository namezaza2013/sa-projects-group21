package com.cpe.backend.menudesign.controller;

import com.cpe.backend.menudesign.entity.FoodTechinque;
import com.cpe.backend.menudesign.repository.FoodTechinqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class FoodTechinqueController {

    @Autowired
    private final FoodTechinqueRepository foodTechinqueRepository;

    public FoodTechinqueController(FoodTechinqueRepository foodTechinqueRepository) {
        this.foodTechinqueRepository = foodTechinqueRepository;
    }

    @GetMapping("/foodTechinque")
    public Collection<FoodTechinque> FoodTechinque() {
        return foodTechinqueRepository.findAll().stream().collect(Collectors.toList());
    }

}