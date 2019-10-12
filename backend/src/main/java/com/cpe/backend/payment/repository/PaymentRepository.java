package com.cpe.backend.payment.repository;

import com.cpe.backend.payment.entity.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface PaymentRepository extends JpaRepository<Payment, Long> {
}