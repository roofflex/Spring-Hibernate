package com.roofflex.springboot.thymeleafdemo.service;

import com.roofflex.springboot.thymeleafdemo.dao.EmployeeJpaRepository;
import com.roofflex.springboot.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    @Override
    public List<Employee> findAll() {
        return employeeJpaRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeJpaRepository.findById(theId);

        Employee employee = null;

        if (result.isPresent()){
            employee = result.get();
        } else{
            throw new RuntimeException("No Employee with such Id - " + theId);
        }
        return employee;
    }

    @Override
    public void save(Employee theEmployee) {
        employeeJpaRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeJpaRepository.deleteById(theId);
    }
}
