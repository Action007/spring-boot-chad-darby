package com.luv2code.springboot.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.luv2code.springboot.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

  private EntityManager entityManager;

  @Autowired
  public EmployeeDAOJpaImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Employee> findAll() {
    TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
    List<Employee> employee = query.getResultList();
    return employee;
  }

  @Override
  public Employee findById(int id) {
    Employee employee = entityManager.find(Employee.class, id);
    return employee;
  }

  @Override
  public Employee save(Employee employee) {
    Employee dbEmployee = entityManager.merge(employee);
    return dbEmployee;
  }

  @Override
  public void deleteById(int id) {
    Employee employee = entityManager.find(Employee.class, id);
    entityManager.remove(employee);
  }
}
