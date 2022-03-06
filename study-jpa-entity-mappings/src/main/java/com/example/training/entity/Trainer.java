package com.example.training.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Trainer {
	@Id
	private String identity;
	private String fullname;
	@Enumerated(EnumType.ORDINAL)
	private Gender gender;

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "trainer_id", referencedColumnName = "identity")
	private List<Course> courses = new ArrayList<>();

	public Trainer() {
		System.err.println("Trainer::Trainer() is running.");
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		System.err.println("Trainer::setIdentity() is running.");
		this.identity = identity;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		System.err.println("Trainer::setFullname() is running.");
		this.fullname = fullname;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		System.err.println("Trainer::setGender() is running.");
		this.gender = gender;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trainer other = (Trainer) obj;
		return Objects.equals(identity, other.identity);
	}

	@Override
	public String toString() {
		return "Trainer [identity=" + identity + ", fullname=" + fullname + ", gender=" + gender + "]";
	}

	public void addTraining(Course course) {
		this.courses.add(course);
	}

}
