package com.roofflex.springboot.cruddemo.dao;

import com.roofflex.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeSpringDataJPARepository extends JpaRepository<Employee, Integer> {
}
