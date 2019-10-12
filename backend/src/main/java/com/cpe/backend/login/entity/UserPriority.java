package com.cpe.backend.login.entity;

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
@Table(name="UserPriority")
public class UserPriority {

    @Id
    @SequenceGenerator(name="UserPriority_seq",sequenceName="UserPriority_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="UserPriority_seq")
    @Column(name = "UserPriority_ID", unique = true)
    private @NonNull Long id;
    
    @Column(name="name")
    private @NonNull String name;
}