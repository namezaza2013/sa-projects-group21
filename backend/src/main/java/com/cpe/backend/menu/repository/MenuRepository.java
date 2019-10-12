package com.cpe.backend.menu.repository;

import com.cpe.backend.menu.entity.Menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface MenuRepository extends JpaRepository<Menu, Long> {
}