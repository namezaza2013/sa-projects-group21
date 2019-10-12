package com.cpe.backend.menu.repository;

import com.cpe.backend.menu.entity.Appropriate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface AppropriateRepository extends JpaRepository<Appropriate, Long> {
    Appropriate findById(long id);
}