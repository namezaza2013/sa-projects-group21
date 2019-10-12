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
@Table(name="TABLEZONE")
public class TableZone {
    @Id
    @SequenceGenerator(name="TABLE_ZONE_SEQ",sequenceName="TABLE_ZONE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TABLE_ZONE_SEQ")
    @Column(name="TABLE_ZONE_ID",unique = true, nullable = true)
    private @NonNull Long id;

    @Column(name="Zone")
    private @NonNull String zone;


    @OneToMany(fetch = FetchType.EAGER)
    // mappedBy  = "createdBy"
    private Collection<Tables> rent;
}