package com.cpe.backend.employee.entity;

import lombok.*;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@NoArgsConstructor
@Table(name="RESPONSIBILITY")
public class Responsibility {
    @Id
    @SequenceGenerator(name="Responsibility_SEQ",sequenceName="Responsibility_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Responsibility_SEQ")
    @Column(name="Responsibility_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String responsibility;

	
}