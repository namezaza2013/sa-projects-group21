package com.cpe.backend.repository;

import com.cpe.backend.entity.MenuType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface MenuTypeRepository extends JpaRepository<MenuType, Long> {
	MenuType findById(long id);
}