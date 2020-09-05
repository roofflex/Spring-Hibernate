package com.roofflex.springboot.springdatarestdemo.dao;

import com.roofflex.springboot.springdatarestdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {
}
