package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

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

    // @OneToMany(fetch = FetchType.EAGER , mappedBy = "appropriate")
    // private Collection<Appropriation> appropriationID;

}
