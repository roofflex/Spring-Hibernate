package com.roofflex.springboot.cruddemo.dao;

import com.roofflex.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getEmployees();

    public Employee getSingleEmployee(int employeeId);

    public void createEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public void deleteEmployee(int employeeId);
}
