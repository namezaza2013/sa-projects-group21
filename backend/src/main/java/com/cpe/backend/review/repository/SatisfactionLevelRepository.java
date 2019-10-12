package com.cpe.backend.review.repository;

import com.cpe.backend.review.entity.SatisfactionLevel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface SatisfactionLevelRepository extends JpaRepository<SatisfactionLevel, Long> {
	SatisfactionLevel findById(long id);
}