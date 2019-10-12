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
@Table(name="EXPERIENCE")
public class Experience {
    @Id
    @SequenceGenerator(name="EXPERIENCE_SEQ",sequenceName="EXPERIENCE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="EXPERIENCE_SEQ")
    @Column(name="EXPERIENCE_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String experience;

    

	

	

}