package com.cpe.backend.order.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@Setter
@NoArgsConstructor
@Table(name="OrderStatus")
public class OrderStatus {

    @Id
    @SequenceGenerator(name="OrderStatus_seq",sequenceName="OrderStatus_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="OrderStatus_seq")
    @Column(name = "ORDER_STATUS_ID", unique = true, nullable = true)
    private @NonNull Long id;
    
    @Column(name="OrderStatusName")
    private @NonNull String name;
}