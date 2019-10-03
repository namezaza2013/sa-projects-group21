package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.FetchType;

import com.cpe.backend.entity.Appropriate;

@Data
@Entity
@NoArgsConstructor
@Table(name="APPROPRIATION")
public class Appropriation {
    @Id
    @SequenceGenerator(name="appropriation_SEQ",sequenceName="appropriation_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="appropriation_SEQ")
    @Column(name="APPROPRIATION_ID",unique = true, nullable = true)
    private @NonNull Long id;

    // @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // @JoinColumn(name = "MENU_ID")
    // private @NonNull Menu menuID;

    // @ManyToOne(fetch = FetchType.EAGER)
    // @JoinColumn(name = "APPROPRIATE_ID")
    // private @NonNull Appropriate appropriateID;

    // @ManyToOne(fetch = FetchType.EAGER, targetEntity = Appropriate.class)
    // @JoinColumn(name = "APPROPRIATE_ID", insertable = true)
    // ublic Nation getNationId() {
    //     return this.nationID;
    // }
    // public void setNationId(Nation nationID) {
    //     this.nationID = nationID;
    // }

}