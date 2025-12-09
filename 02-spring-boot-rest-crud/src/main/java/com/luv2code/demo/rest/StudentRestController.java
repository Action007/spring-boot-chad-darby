package com.luv2code.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class StudentRestController {

  private List<Student> students;

  @PostConstruct
  public void loadData() {
    students = new ArrayList<>();
    students.add(new Student("Poornima", "Patel"));
    students.add(new Student("Maria", "Rossi"));
    students.add(new Student("Mary", "Smith"));
  }

  @GetMapping("/students")
  public List<Student> getStudents() {
    return students;
  }

  @GetMapping("/students/{studentId}")
  public Student getMethodName(@PathVariable int studentId) {
    if ((studentId >= students.size()) || studentId < 0) {
      throw new StudentNotFoundException("Student id not found - " + studentId);
    }

    return students.get(studentId);
  }
}
