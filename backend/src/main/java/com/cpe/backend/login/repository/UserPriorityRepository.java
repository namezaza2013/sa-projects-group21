package com.cpe.backend.login.repository;

import com.cpe.backend.login.entity.UserPriority;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface UserPriorityRepository extends JpaRepository<UserPriority, Long> {
  UserPriority findById(long id);
}