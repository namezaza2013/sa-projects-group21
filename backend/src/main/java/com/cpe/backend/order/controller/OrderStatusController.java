package com.cpe.backend.order.controller;

import com.cpe.backend.order.entity.OrderStatus;
import com.cpe.backend.order.repository.OrderStatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class OrderStatusController {

    @Autowired
    private final OrderStatusRepository orderStatusRepository;

    public OrderStatusController(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }

    @GetMapping("/orderStatus")
    public Collection<OrderStatus> TableType() {
        return orderStatusRepository.findAll().stream().collect(Collectors.toList());
    }

}