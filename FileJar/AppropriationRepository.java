package com.cpe.backend.repository;

import java.util.Collection;

import com.cpe.backend.entity.Appropriation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface AppropriationRepository extends JpaRepository<Appropriation, Long> {
    Collection<Appropriation> findById(long id);
}