package com.cpe.backend.login.repository;

import com.cpe.backend.login.entity.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface AccountRepository extends JpaRepository<Account, Long> {
    Account findById(long id);
    Account findByUsername(String username);
}