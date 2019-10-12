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
@Table(name="WORKTYPE")
public class WorkType {
    @Id
    @SequenceGenerator(name="TYPE_SEQ",sequenceName="TYPE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TYPE_SEQ")
    @Column(name="TYPE_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String worktype;


}