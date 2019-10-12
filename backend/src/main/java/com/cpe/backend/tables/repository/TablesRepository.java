package com.cpe.backend.tables.repository;

import com.cpe.backend.tables.entity.Tables;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface TablesRepository extends JpaRepository<Tables, Long> {
	Tables findById(long id);
}
