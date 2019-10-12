package com.cpe.backend.employee.repository;

import com.cpe.backend.employee.entity.WorkType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface WorkTypeRepository extends JpaRepository<WorkType, Long> {
    WorkType findById(long id);
}