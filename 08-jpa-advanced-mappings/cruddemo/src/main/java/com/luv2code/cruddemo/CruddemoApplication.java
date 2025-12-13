package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return (runner) -> {
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			removeInstructor(appDAO);
		};
	}

	private void removeInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Deleting instructor with id: " + id);
		appDAO.deleteInstructorById(id);
		System.out.println("done");
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding instructor id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("instructor: " + instructor);
		System.out.println("the associated instructorDetail only: " + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		// Instructor instructor = new Instructor("Chad", "Darby",
		// "darby@luv2code.com");
		// InstructorDetail instructorDetail = new
		// InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");

		Instructor instructor = new Instructor("Eazy", "Bytes", "eazybytes@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.eazybytes.com/youtube", "Eazy Bytes code!!!");

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: " + instructor);
		appDAO.save(instructor);

		System.out.println("Done!");
	}
}
