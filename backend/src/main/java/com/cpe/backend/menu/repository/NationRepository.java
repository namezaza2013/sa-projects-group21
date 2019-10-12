package com.cpe.backend.menu.repository;

import com.cpe.backend.menu.entity.Nation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface NationRepository extends JpaRepository<Nation, Long> {
	Nation findById(long id);
}