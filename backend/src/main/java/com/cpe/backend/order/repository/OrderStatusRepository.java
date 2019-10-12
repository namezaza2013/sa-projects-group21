
package com.cpe.backend.order.repository;

import com.cpe.backend.order.entity.OrderStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {
    OrderStatus findById(long id);
}