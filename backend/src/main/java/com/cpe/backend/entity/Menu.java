package com.cpe.backend.entity;

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

@Data
@Entity
@NoArgsConstructor
@Table(name="MENU")
public class Menu {

    @CrossOrigin(origins = "*")
@Data
@Entity
@NoArgsConstructor
@Table(name = "MENU")
public class Menu {
    @Id
    @SequenceGenerator(name = "MENU_SEQ", sequenceName = "MENU_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MENU_SEQ")
    @Column(name = "MENU_ID", unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String menuName;
    private @NonNull Integer menuPrice;
    private @NonNull Integer menuUnits;


}


    // @ManyToOne(fetch = FetchType.EAGER, targetEntity = MenuType.class)
    // @JoinColumn(name = "MENUTYPE_ID",unique = true, insertable = true)
    // private MenuType menuTypeID;
    // public MenuType getMenuTypeID() {
    //     return this.menuTypeID;
    // }
    // public void setMenuTypeID(MenuType menuTypes) {
    //     this.menuTypeID = menuTypes;
    // }

    // @ManyToOne(fetch = FetchType.EAGER, targetEntity = Nation.class)
    // @JoinColumn(name = "NATION_ID", insertable = true)
    // private Nation nationID;

    // public Nation getNationId() {
    //     return this.nationID;
    // }
    // public void setNationId(Nation nationID) {
    //     this.nationID = nationID;
    // }

    // @OneToMany(fetch = FetchType.EAGER, mappedBy = "menu")
    // // @JoinColumn(name = "APPROPRIATION_ID", insertable = true)
    // @JsonManagedReference
    // private Collection<Appropriation> appropriationID;
    // public Collection<Appropriation> getAppropriationID() {
    //     return this.appropriationID;
    // }
    // public void setAppropriationId(Collection<Appropriation> appropriationID) {
    //     this.appropriationID = appropriationID;
    // }





	

}