package com.cpe.backend.tables.entity;

import lombok.*;

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
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="TABLES")
public class Tables {

    @Id
    @SequenceGenerator(name="TABLES_seq",sequenceName="TABLES_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TABLES_seq")  
    @Column(name = "TABLES_ID", unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String tablesName;
    private @NonNull Integer seat;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TableType.class)
    @JoinColumn(name = "TABLE_TYPE_ID", insertable = true)
    private TableType tableType;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TableZone.class)
    @JoinColumn(name = "TABLE_ZONE_ID", insertable = true)
    private TableZone tableZone;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TableStatus.class)
    @JoinColumn(name = "TABLE_STATUS_ID", insertable = true)
    private TableStatus tableStatus;
}