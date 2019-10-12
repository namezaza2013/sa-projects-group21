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
@Table(name="IMPROVEMENT_TYPE")
public class ImprovementType {
    @Id    
    @SequenceGenerator(name="IMPROVEMENT_TYPE_SEQ",sequenceName="IMPROVEMENT_TYPE_SEQ")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="IMPROVEMENT_TYPE_SEQ")  
    @Column(name="IMPROVEMENT_TYPE_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String improveName;

    @OneToMany(fetch = FetchType.EAGER)
    // mappedBy  = "reviewImprovementType"
    private Collection<Review> review;
}