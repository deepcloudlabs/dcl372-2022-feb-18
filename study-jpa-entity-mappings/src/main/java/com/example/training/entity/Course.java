package com.example.training.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trainings")
public class Course {
	@Id
	private String courseId;
	private String title;

	@ManyToOne(optional = false)
	@JoinColumn(name= "trainer_id", referencedColumnName = "identity")
	private Trainer trainer;
	
	public Course() {
		System.err.println("Course::Course() is running.");
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		System.err.println("Course::setCourseId() is running.");
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public void setTitle(String title) {
		System.err.println("Course::setTitle() is running.");
		this.title = title;
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(courseId, other.courseId);
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", title=" + title + "]";
	}

}
