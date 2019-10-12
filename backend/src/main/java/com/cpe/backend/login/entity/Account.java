package com.cpe.backend.login.entity;

import com.cpe.backend.employee.entity.*;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;


@Data
@Entity
@Setter
@NoArgsConstructor
@Table(name="Account")
public class Account {

    @Id
    @SequenceGenerator(name="Account_seq",sequenceName="Account_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Account_seq")
    @Column(name = "Account_2ID", unique = true, nullable = true)
    private @NonNull Long id;
    
    @Column(name="username")
    private @NonNull String username;

    @Column(name="password")
    private @NonNull String password;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = UserPriority.class)
    @JoinColumn(name="Priority_ID",insertable = true)
    private @NonNull UserPriority userPriority;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class)
    @JoinColumn(name="Employee_ID",insertable = true)
    private @NonNull Employee employee;
}