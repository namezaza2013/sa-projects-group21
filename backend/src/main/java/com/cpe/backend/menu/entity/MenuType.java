package com.cpe.backend.menu.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

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

}