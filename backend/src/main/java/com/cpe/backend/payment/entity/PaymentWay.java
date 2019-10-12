package com.cpe.backend.payment.entity;

import lombok.*;

import javax.persistence.Id;

// import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@NoArgsConstructor
@Table(name="PAYMENT_WAY")
public class PaymentWay {
    @Id
    @SequenceGenerator(name="PAYMENT_WAY_SEQ",sequenceName="PAYMENT_WAY_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PAYMENT_WAY_SEQ")
    @Column(name="PAYMENT_WAY_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String name;

}