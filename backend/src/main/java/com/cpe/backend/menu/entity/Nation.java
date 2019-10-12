package com.cpe.backend.menu.entity;

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
@Table(name="NATION")
public class Nation {
    @Id
    @SequenceGenerator(name="NATION_SEQ",sequenceName="NATION_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="NATION_SEQ")
    @Column(name="NATION_ID",unique = true, nullable = true)
    private @NonNull Long id;
    private @NonNull String nationName;

    // public String getNationName() {
    //     return this.nationName;
    // }
    // public void setNationName(String nationName) {
    //     this.nationName = nationName;
    // }
}