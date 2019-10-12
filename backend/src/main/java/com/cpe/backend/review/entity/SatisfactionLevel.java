package com.cpe.backend.review.entity;
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
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="SATISFACTION_LEVEL")
public class SatisfactionLevel {
    @Id    
    @SequenceGenerator(name="SLEVEL_SEQ",sequenceName="SLEVEL_SEQ")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SLEVEL_SEQ")  
    @Column(name="SATISFACTION_LEVEL_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String satisName;

    @OneToMany(fetch = FetchType.EAGER)
    // mappedBy  = "reviewSatiscationLevel"
    private Collection<Review> review;
}