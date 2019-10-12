package com.cpe.backend.tables.repository;

import com.cpe.backend.tables.entity.TableType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface TableTypeRepository extends JpaRepository<TableType, Long> {
	TableType findById(long id);
}