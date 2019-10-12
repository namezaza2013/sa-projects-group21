package com.cpe.backend.menudesign.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@Data
@Entity
@NoArgsConstructor
@Table(name = "FOODIMAGE")
public class FoodImage {
    @Id
    @SequenceGenerator(name = "FOODIMAGE_SEQ", sequenceName = "FOODIMAGE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FOODIMAGE_SEQ")
    @Column(name = "FOODIMAGE_ID", unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String nameImage;

    private @NonNull String urlImage;

    @OneToOne(mappedBy = "foodImage", cascade = CascadeType.ALL)
    @JsonIgnore
    private MenuDesign menuDesign;
}