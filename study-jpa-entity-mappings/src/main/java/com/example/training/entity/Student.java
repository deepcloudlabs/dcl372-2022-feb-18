package com.example.training.entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
@Table(name="participants")
public class Student {
	@Id
	private String id;
	private String fullname;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
}
