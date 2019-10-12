package com.cpe.backend.menudesign.controller;

import com.cpe.backend.menudesign.entity.FoodImage;
import com.cpe.backend.menudesign.repository.FoodImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class FoodImageController {

    @Autowired
    private final FoodImageRepository foodImageRepository;

    public FoodImageController(FoodImageRepository foodImageRepository) {

        this.foodImageRepository = foodImageRepository;
    }

    @GetMapping("/foodImage")
    public Collection<FoodImage> foodImages() {
        return foodImageRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/foodImage/{id}")
    public Optional<FoodImage> foodimage(@PathVariable Long id) {
        Optional<FoodImage> foodimage = foodImageRepository.findById(id);
        return foodimage;
    }

}