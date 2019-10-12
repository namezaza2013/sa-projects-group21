package com.cpe.backend.employee.entity;

import lombok.*;
import com.cpe.backend.employee.entity.Employee;
import com.cpe.backend.employee.entity.Responsibility;
import com.cpe.backend.employee.entity.Experience;
import com.cpe.backend.employee.entity.WorkType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@NoArgsConstructor
@Table(name="Employee")
public class Employee {

    @Id
    @SequenceGenerator(name="employee_seq",sequenceName="employee_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="employee_seq")
    @Column(name = "Employee_ID", unique = true, nullable = true)
    private @NonNull Long id;
    @Column(name="NAME")

    private @NonNull String name;

    private @NonNull String address;

    private @NonNull String nickname;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Responsibility.class)
    @JoinColumn(name = "Responsibility_ID", insertable = true)
    private Responsibility addresponsibility;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Experience.class)
    @JoinColumn(name = "EXPERIENCE_ID", insertable = true)
    private  Experience addexperience;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = WorkType.class)
    @JoinColumn(name = "WORKTYPE_ID", insertable = true)
    private WorkType addworktype;

    // @OneToMany(fetch = FetchType.EAGER)
    // // mappedBy  = "reviewEmployee"
    // private Collection<Review> review;

}