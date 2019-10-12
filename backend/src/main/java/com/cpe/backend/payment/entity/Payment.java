package com.cpe.backend.payment.entity;

import lombok.*;

import com.cpe.backend.order.entity.*;
import com.cpe.backend.employee.entity.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

// import com.cpe.backend.payment.entity.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="PAYMENT")
public class Payment {

    @Id
    @SequenceGenerator(name="payment_seq",sequenceName="payment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="payment_seq")
    @Column(name = "PAYMENT_ID", unique = true, nullable = true)
    private @NonNull Long id;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Order.class)
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PaymentWay.class)
    @JoinColumn(name = "PAYMENT_WAY_ID", insertable = true)
    private PaymentWay paymentWay;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class)
    @JoinColumn(name = "EMPLOYEE_ID", insertable = true)
    private Employee createdBy;

	@Column(name="PAY_DATE")
    private @NonNull Date payDate;
}