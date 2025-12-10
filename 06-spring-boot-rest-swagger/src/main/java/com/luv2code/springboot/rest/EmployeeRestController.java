package com.luv2code.springboot.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.luv2code.springboot.entity.Employee;
import com.luv2code.springboot.service.EmployeeService;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.node.ObjectNode;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api")
public class EmployeeRestController {

  private EmployeeService employeeService;
  private ObjectMapper objectMapper;

  @Autowired
  public EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper) {
    this.employeeService = employeeService;
    this.objectMapper = objectMapper;
  }

  @GetMapping("/employees")
  public List<Employee> findAll() {
    return employeeService.findAll();
  }

  @GetMapping("/employees/{employeeId}")
  public Employee getEmployee(@PathVariable int employeeId) {
    Employee employee = employeeService.findById(employeeId);

    if (employee == null) {
      throw new RuntimeException("Employee id not found - " + employeeId);
    }

    return employee;
  }

  @PostMapping("/employees")
  public Employee postMethodName(@RequestBody Employee employee) {
    employee.setId(0);
    Employee dbEmployee = employeeService.save(employee);
    return dbEmployee;
  }

  @PutMapping("/employees")
  public Employee putMethodName(@RequestBody Employee employee) {
    Employee dbEmployee = employeeService.save(employee);
    return dbEmployee;
  }

  @DeleteMapping("/employees/{employeeId}")
  public String deleteEmployee(@PathVariable int employeeId) {
    Employee employee = employeeService.findById(employeeId);

    if (employee == null) {
      throw new RuntimeException("Employee id not found - " + employeeId);
    }

    employeeService.deleteById(employeeId);
    return "Deleted employee id - " + employeeId;
  }

  @PatchMapping("/employees/{employeeId}")
  public Employee patchEmployee(@PathVariable int employeeId,
      @RequestBody Map<String, Object> patchPayload) {
    Employee employee = employeeService.findById(employeeId);

    if (employee == null) {
      throw new RuntimeException("Empolyee id not found - " + employeeId);
    }

    if (patchPayload.containsKey("id")) {
      throw new RuntimeException("Empolyee id not allowed in request body - " + employeeId);
    }

    Employee patchedEmployee = apply(patchPayload, employee);
    Employee dbEmployee = employeeService.save(patchedEmployee);

    return dbEmployee;
  }

  private Employee apply(Map<String, Object> patchPayload, Employee employee) {
    ObjectNode employeeNode = objectMapper.convertValue(employee, ObjectNode.class);
    ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);
    employeeNode.setAll(patchNode);

    return objectMapper.convertValue(employeeNode, Employee.class);
  }
}
