package com.cpe.backend.payment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

import com.cpe.backend.payment.entity.PaymentWay;
import com.cpe.backend.payment.repository.PaymentWayRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PaymentWayController {

    @Autowired
    private final PaymentWayRepository paymentWayRepository;

    public PaymentWayController(PaymentWayRepository paymentWayRepository) {
        this.paymentWayRepository = paymentWayRepository;
    }

    @GetMapping("/paymentWay")
    public Collection<PaymentWay> PaymentWays() {
        return paymentWayRepository.findAll().stream().collect(Collectors.toList());
    }

}