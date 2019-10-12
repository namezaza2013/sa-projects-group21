package com.cpe.backend.order.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import com.cpe.backend.tables.entity.Tables;
import com.cpe.backend.order.entity.OrderStatus;
import com.cpe.backend.order.entity.MenuOrder;

@Data
@Entity
@NoArgsConstructor
@Setter
@Table(name="\"ORDER\"")
public class Order {

    @Id
    @SequenceGenerator(name="order_seq",sequenceName="order_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="order_seq")
    @Column(name = "ORDER_ID", unique = true, nullable = true)
    private @NonNull Long id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Tables.class)
    @JoinColumn(name = "TABLES_ID", insertable = true)
    @JsonManagedReference
    private @NonNull Tables tables;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = OrderStatus.class)
    @JoinColumn(name="ORDER_STATUS_ID",insertable = true)
    @JsonManagedReference
    private OrderStatus orderStatus;

    @OneToMany(
        mappedBy = "order",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JsonManagedReference
    private Collection<MenuOrder> menuOrders = new ArrayList<MenuOrder>();;

    @Column(name="DESC")
    @JsonManagedReference
    private @NonNull String desc;

    @Column(name="DATE")
    private @NonNull Date date;

    //Constructors, getters and setters removed for brevity
    public void addMenuOrder(MenuOrder menuOrder) {
        menuOrder.setOrder(this);
        System.out.println("==================");
        System.out.println("addMenuOrder(OrderEntity) = "+menuOrder.getId());
        this.menuOrders.add(menuOrder);
        System.out.println("==================");
    }
    public void removeMenuOrder(MenuOrder menuOrder) {
        menuOrder.setOrder(null);
        this.menuOrders.remove(menuOrder);
    }
}