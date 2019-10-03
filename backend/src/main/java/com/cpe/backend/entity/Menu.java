package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

import com.cpe.backend.entity.MenuType;
import com.cpe.backend.entity.Nation;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.cpe.backend.entity.Appropriation;

@Data
@Entity
@NoArgsConstructor
@Table(name="MENU")
public class Menu {

    @Id
    @SequenceGenerator(name="menulist_seq",sequenceName="menulist_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="menulist_seq")
    @Column(name = "MENU_ID", unique = true, nullable = true)
    private @NonNull Long id;
    @Column(name = "menuName")
    private @NonNull String menuName;
    public String getMenuName() {
        return this.menuName;
    }
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    @Column(name = "menuPrice")
    private @NonNull Integer menuPrice;
    public Integer getMenuPrice() {
        return this.menuPrice;
    }
    public void setMenuPrice(Integer menuPrice) {
        this.menuPrice = menuPrice;
    }
    @Column(name = "menuUnits")
    private @NonNull Integer menuUnits;
    public Integer getMenuUnits() {
        return this.menuPrice;
    }
    public void setMenuUnits(Integer menuUnits) {
        this.menuUnits = menuUnits;
    }


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = MenuType.class)
    @JoinColumn(name = "MENUTYPE_ID",unique = true, insertable = true)
    private MenuType menuTypeID;
    public MenuType getMenuTypeID() {
        return this.menuTypeID;
    }
    public void setMenuTypeID(MenuType menuTypes) {
        this.menuTypeID = menuTypes;
    }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Nation.class)
    @JoinColumn(name = "NATION_ID", insertable = true)
    private Nation nationID;
    public Nation getNationId() {
        return this.nationID;
    }
    public void setNationId(Nation nationID) {
        this.nationID = nationID;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "menu")
    // @JoinColumn(name = "APPROPRIATION_ID", insertable = true)
    @JsonManagedReference
    private Collection<Appropriation> appropriationID;
    public Collection<Appropriation> getAppropriationID() {
        return this.appropriationID;
    }
    public void setAppropriationId(Collection<Appropriation> appropriationID) {
        this.appropriationID = appropriationID;
    }





	

}