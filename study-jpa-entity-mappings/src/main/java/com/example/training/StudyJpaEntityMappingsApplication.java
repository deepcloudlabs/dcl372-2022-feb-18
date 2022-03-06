package com.example.training;

import java.util.Objects;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.example.training.entity.Course;
import com.example.training.entity.Gender;
import com.example.training.entity.Trainer;

@SpringBootApplication
public class StudyJpaEntityMappingsApplication implements ApplicationRunner {
	@Autowired
	private EntityManager em;

	public static void main(String[] args) {
		SpringApplication.run(StudyJpaEntityMappingsApplication.class, args);
	}

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		var jack = em.find(Trainer.class, "1"); 
		System.out.println(jack);
		//jack.getCourses().forEach(System.out::println);
	}

	public void createNewTraining() {
		var jack = em.find(Trainer.class, "1"); 
		var dcl300 = new Course();
		dcl300.setCourseId("DCL300");
		dcl300.setTitle("introduction to algorithms");
		dcl300.setTrainer(jack);
		em.persist(dcl300);		
	}
	
	public void findDcl100() {
		var dcl100 = em.find(Course.class, "DCL100");
		if (Objects.nonNull(dcl100)) {
			System.out.println(dcl100);
			System.out.println(dcl100.getTrainer());
		}
	}

	public void findJack() {
		var jack = em.find(Trainer.class, "1");
		if (Objects.nonNull(jack)) {
			System.out.println(jack);
			jack.getCourses().forEach(System.out::println);
		}
	}

	public void addTrainer() {
		var course1 = new Course();
		course1.setCourseId("DCL100");
		course1.setTitle("introduction to computing");
		var course2 = new Course();
		course2.setCourseId("DCL200");
		course2.setTitle("introduction to java");
		var jack = new Trainer();
		jack.setIdentity("1");
		jack.setFullname("Jack Bauer");
		jack.setGender(Gender.MALE);
		jack.addTraining(course1);
		jack.addTraining(course2);
		em.persist(jack);
	}

}
