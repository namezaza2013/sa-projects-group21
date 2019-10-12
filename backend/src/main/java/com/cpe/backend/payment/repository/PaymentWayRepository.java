package com.cpe.backend.payment.repository;

import com.cpe.backend.payment.entity.PaymentWay;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface PaymentWayRepository extends JpaRepository<PaymentWay, Long> {
	PaymentWay findById(long id);
}