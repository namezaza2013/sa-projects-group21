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
@Table(name="TABLETYPE")
public class TableType {
    @Id
    @SequenceGenerator(name="TABLE_TYPE_SEQ",sequenceName="TABLE_TYPE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TABLE_TYPE_SEQ")
    @Column(name="TABLE_TYPE_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String typeName;

    @OneToMany(fetch = FetchType.EAGER)
    // mappedBy  = "createdBy"
    private Collection<Tables> rent;
}