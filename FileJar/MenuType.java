package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;

import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.engine.spi.CollectionEntry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@NoArgsConstructor
@Table(name="MENUTYPE")
public class MenuType {
	@Id
	@SequenceGenerator(name="menutype_seq",sequenceName="menutype_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="menutype_seq")
	@Column(name="MENUTYPE_ID",unique = true, nullable = true)
    private @NonNull Long id;
    private @NonNull String typeName;
	// public Long setMenuTypeID() {
    //     return this.id;
    // }
    // public void getMenuTypeID(Long id) {
    //     this.id = id;
    // }
	// public String getTypeName() {
    //     return this.typeName;
    // }
    // public void setTypeName(String typeName) {
    //     this.typeName = typeName;
	// }

}