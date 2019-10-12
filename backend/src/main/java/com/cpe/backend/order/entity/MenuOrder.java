package com.cpe.backend.order.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import com.cpe.backend.order.entity.Order;
import com.cpe.backend.menu.entity.Menu;


import com.fasterxml.jackson.annotation.*;
@Data
@Entity
@NoArgsConstructor
@Setter
@Table(name="MenuOrder")
public class MenuOrder {

    @Id
    @SequenceGenerator(name="menu_order_seq",sequenceName="menu_order_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="menu_order_seq")
    @Column(name = "MENU_ORDER_ID", unique = true, nullable = true)
    private @NonNull Long id;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Order.class)
    @JoinColumn(name = "menuOrder")
    @JsonIgnore
    private Order order;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MENU_LIST_ID")
    private @NonNull Menu menu;
}