package com.cpe.backend.tables.entity;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.cpe.backend.tables.entity.Tables;
@Data
@Entity
@NoArgsConstructor
@Table(name="TABLESTATUS")
public class TableStatus {
    @Id
    @SequenceGenerator(name="TABLE_STATUS_SEQ",sequenceName="TABLE_STATUS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TABLE_STATUS_SEQ")
    @Column(name="TABLE_STATUS_ID",unique = true, nullable = true)
    private @NonNull Long id;

    @Column(name="state")
    private @NonNull String state;

    @OneToMany(fetch = FetchType.EAGER)
    // mappedBy  = "createdBy"
    private Collection<Tables> rent;
}