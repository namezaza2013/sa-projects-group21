package com.cpe.backend.review.repository;

import com.cpe.backend.review.entity.ImprovementType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface ImprovementTypeRepository extends JpaRepository<ImprovementType, Long> {
	ImprovementType findById(long id);
}