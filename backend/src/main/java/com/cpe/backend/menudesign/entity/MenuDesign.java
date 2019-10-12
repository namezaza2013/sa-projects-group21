package com.cpe.backend.menudesign.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cpe.backend.menu.entity.Menu;

import org.springframework.web.bind.annotation.CrossOrigin;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@CrossOrigin(origins = "*")
@Data
@Entity
@NoArgsConstructor
@Table(name = "MENUDESIGN")
public class MenuDesign {

    @Id
    @SequenceGenerator(name = "MENUDESIGN_SEQ", sequenceName = "MENUDESIGN_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MENUDESIGN_SEQ")
    @Column(name = "MENUDESIGN_ID", unique = true, nullable = true)
    private @NonNull Long id;

    @Column(name = "Desciption")
    private @NonNull String desciption;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = FoodTechinque.class)
    @JoinColumn(name = "TECHNIQUE_ID", insertable = true)
    private @NonNull FoodTechinque foodTechinque;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = FoodImage.class)
    @JoinColumn(name = "FOODIMAGE_ID", referencedColumnName = "FOODIMAGE_ID",unique = true)
    private FoodImage foodImage;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Menu.class)
    @JoinColumn(name = "MENU_ID", referencedColumnName = "MENU_ID", unique = true)
    private @NonNull Menu menu;

}