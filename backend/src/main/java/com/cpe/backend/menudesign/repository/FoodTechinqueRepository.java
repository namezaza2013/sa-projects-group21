package com.cpe.backend.menudesign.repository;

import com.cpe.backend.menudesign.entity.FoodTechinque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FoodTechinqueRepository extends JpaRepository<FoodTechinque, Long> {
    FoodTechinque findById(long id);
}