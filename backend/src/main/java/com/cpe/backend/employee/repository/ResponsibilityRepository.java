package com.cpe.backend.employee.repository;

import com.cpe.backend.employee.entity.Responsibility;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface ResponsibilityRepository extends JpaRepository<Responsibility, Long> {
	Responsibility findById(long id);
}