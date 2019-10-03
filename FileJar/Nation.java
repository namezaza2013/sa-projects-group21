package com.cpe.backend.entity;

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
    //     return this.natioNname;
    // }
    // public void setNationName(String natioNname) {
    //     this.natioNname = natioNname;
    // }

    // @OneToMany(fetch = FetchType.EAGER)
    // private Collection<Menu> menuID;
}