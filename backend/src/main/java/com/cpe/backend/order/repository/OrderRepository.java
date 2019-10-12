package com.cpe.backend.order.repository;

import com.cpe.backend.order.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface OrderRepository extends JpaRepository<Order, Long> {
	Order findById(long id);
}