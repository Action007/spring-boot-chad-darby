package com.luv2code.springboot.dao;

import java.util.List;
import com.luv2code.springboot.entity.Employee;

public interface EmployeeDAO {
  List<Employee> findAll();

  Employee findById(int id);

  Employee save(Employee employee);

  void deleteById(int id);
}
