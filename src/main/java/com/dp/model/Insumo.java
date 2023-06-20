package com.dp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Insumo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	private String gender; 
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Name name;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Location location;
	private String email;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Dob dob;

	@ManyToOne(cascade=CascadeType.PERSIST)
	private Registered registered;
	
	@JsonFormat(pattern = "+55")
	private String phone;
	private String cell;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Picture picture;
	
	private String nationality = "BR";
	
}

