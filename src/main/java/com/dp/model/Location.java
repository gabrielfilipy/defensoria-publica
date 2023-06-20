package com.dp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String region;
	private String street;
	private String city;
	private String state;
	private Integer postcode;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Coordinates coordinates;
	
}
