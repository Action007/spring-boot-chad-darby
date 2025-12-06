package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return (runner) -> {
			// createStudent(studentDAO);

			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.err.println("Creating new student object...");
		Student student1 = new Student("1", "11", "test1@gmail.com");
		Student student2 = new Student("2", "22", "test2@gmail.com");
		Student student3 = new Student("3", "33", "test3@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.err.println("Creating new student object...");
		Student student = new Student("Aqshin", "Baghirzade", "aqshin.baghirzade@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(student);

		System.out.println("Saved student. Generated id:" + student.getId());
	}
}
