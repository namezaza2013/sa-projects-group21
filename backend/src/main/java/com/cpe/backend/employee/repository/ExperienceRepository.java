package com.cpe.backend.employee.repository;

import com.cpe.backend.employee.entity.Experience;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface ExperienceRepository extends JpaRepository<Experience, Long> {
    Experience findById(long id);
}