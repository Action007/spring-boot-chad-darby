package com.luv2code.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
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
			// removeInstructor(appDAO);
			// findInstructorDetail(appDAO);
			// deleteInstructorDetail(appDAO);
			// createInstructorWithCourses(appDAO);
			// findInstructorWithCourses(appDAO);
			findCoursesForInstructor(appDAO);
			// findInstructorWithCoursesJoinFetch(appDAO);
		};
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;
		System.out.println("finding instructor id: " + id);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
		System.out.println("instructor: " + instructor);
		System.out.println("the associate courses: " + instructor.getCourses());
		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor with id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("instructor: " + instructor);
		System.out.println("finding course for instructor id: " + id);

		List<Course> courses = appDAO.findCoursesByInstructorId(id);
		instructor.setCourses(courses);

		System.out.println("the associated courses: " + instructor.getCourses());
		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor with id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("instructor: " + instructor);
		System.out.println("the associate courses: " + instructor.getCourses());

		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("Eazy", "Bytes", "eazybytes@gmail.com");
		InstructorDetail instructorDetail =
				new InstructorDetail("http://www.eazybytes.com/youtube", "Eazy Bytes code!!!");

		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Master Microservices with SpringBoot,Docker,Kubernetes");
		Course course2 = new Course("Event Driven Microservices with CQRS, Saga, Event Sourcing");

		instructor.addCourse(course1);
		instructor.addCourse(course2);

		System.out.println("Saving instructor: " + instructor);
		System.out.println("The courses: " + instructor.getCourses());
		appDAO.save(instructor);

		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 3;
		System.out.println("Deleting instructor detailed id: " + id);
		appDAO.deleteInstructorDetailById(id);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id = 2;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		System.out.println("instructorDetail: " + instructorDetail);
		System.out.println("the associated instructor: " + instructorDetail.getInstructor());
		System.out.println("Done!");
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
		InstructorDetail instructorDetail =
				new InstructorDetail("http://www.eazybytes.com/youtube", "Eazy Bytes code!!!");

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: " + instructor);
		appDAO.save(instructor);

		System.out.println("Done!");
	}
}
