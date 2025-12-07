package com.luv2code.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


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
    return students.get(studentId);
  }
}
