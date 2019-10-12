package com.cpe.backend.review.entity;
import com.cpe.backend.employee.entity.Employee;
import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "REVIEW")
public class Review {
    @Id
    @SequenceGenerator(name = "REVIEW_SEQ", sequenceName = "REVIEW_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REVIEW_SEQ")
    @Column(name = "REVIEW_ID", unique = true, nullable = true)
    private @NonNull Long id;

    @Column(name = "REVIEW_DATE")
    private @NonNull Date reviewDate;

    @Column(name = "REVIEW_COMMENT", nullable = true)
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = SatisfactionLevel.class)
    @JoinColumn(name = "SATISFACTION_LEVEL_ID", insertable = true)
    private SatisfactionLevel reviewSatis;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class)
    @JoinColumn(name = "EMPLOYEE_ID", insertable = true)
    private Employee reviewEmployee;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ImprovementType.class)
    @JoinColumn(name = "IMPROVEMENT_TYPE_ID", insertable = true)
    private ImprovementType reviewImprovementType;

}