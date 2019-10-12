package com.cpe.backend.menudesign.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@Data
@Entity
@NoArgsConstructor
@Table(name = "FOODTECHNIQUE")
public class FoodTechinque {
    @Id
    @SequenceGenerator(name = "FOODTECHNIQUE_SEQ", sequenceName = "FOODTECHNIQUE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FOODTECHNIQUE_SEQ")
    @Column(name = "TECHNIQUE_ID", unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String nameTechinques;

    @OneToMany(fetch = FetchType.EAGER)
    private Collection<MenuDesign> menuDesign;

}