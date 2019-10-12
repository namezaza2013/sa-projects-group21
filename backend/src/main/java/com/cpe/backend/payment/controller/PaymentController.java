package com.cpe.backend.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import com.cpe.backend.order.entity.Order;
import com.cpe.backend.employee.entity.Employee;
import com.cpe.backend.payment.entity.Payment;
import com.cpe.backend.payment.entity.PaymentWay;
import com.cpe.backend.order.repository.OrderRepository;
import com.cpe.backend.employee.repository.EmployeeRepository;
import com.cpe.backend.payment.repository.PaymentRepository;
import com.cpe.backend.payment.repository.PaymentWayRepository;


import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PaymentController {
    @Autowired
    private final PaymentRepository paymentRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PaymentWayRepository paymentWayRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    
    PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @GetMapping("/payment")
    public Collection<Payment> Payments() {
        return paymentRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/payment/{order_id}/{paymentWay_id}/{employee_id}")
    public Payment newPayment(Payment newPayment,
    @PathVariable long order_id,
    @PathVariable long paymentWay_id,
    @PathVariable long employee_id) {
    //VideoRental newVideoRental = new VideoRental();

    Order orders = orderRepository.findById(order_id);
    PaymentWay paymentWay = paymentWayRepository.findById(paymentWay_id);
    Employee createdBy = employeeRepository.findById(employee_id);
    
    newPayment.setOrder(orders);
    newPayment.setPaymentWay(paymentWay);
    newPayment.setCreatedBy(createdBy);
    newPayment.setPayDate(new Date());


    return paymentRepository.save(newPayment); //บันทึก Objcet ชื่อ VideoRental
    
    }
}