package com.cpe.backend.tables.repository;

import com.cpe.backend.tables.entity.TableStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface TableStatusRepository extends JpaRepository<TableStatus, Long> {
	TableStatus findById(long id);
}
