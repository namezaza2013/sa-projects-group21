package com.cpe.backend.order.repository;

import com.cpe.backend.order.entity.MenuOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface MenuOrderRepository extends JpaRepository<MenuOrder, Long> {
    MenuOrder findById(long id);
}