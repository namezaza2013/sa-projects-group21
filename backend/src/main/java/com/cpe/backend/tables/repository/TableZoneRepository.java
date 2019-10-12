package com.cpe.backend.tables.repository;

import com.cpe.backend.tables.entity.TableZone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface TableZoneRepository extends JpaRepository<TableZone, Long> {
	TableZone findById(long id);
}
