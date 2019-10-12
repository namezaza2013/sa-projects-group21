package com.cpe.backend.menu.entity;

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
@NoArgsConstructor
@Table(name="APPROPRIATE")
public class Appropriate {

    @Id
    @SequenceGenerator(name="appropriate_seq",sequenceName="appropriate_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="appropriate_seq")  
    @Column(name = "APPROPRIATE_ID", unique = true, nullable = true)
    private @NonNull Long id;
    private @NonNull String appropriationName;

    
    // public String getAppropriationName() {
    //     return this.appropriationName;
    // }
    // public void setAppropriationName(String appropriationName) {
    //     this.appropriationName = appropriationName;
    // }
}
