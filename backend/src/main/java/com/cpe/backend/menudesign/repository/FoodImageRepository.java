package com.cpe.backend.menudesign.repository;

import com.cpe.backend.menudesign.entity.FoodImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FoodImageRepository extends JpaRepository<FoodImage, Long> {
    FoodImage findById(long id);
}