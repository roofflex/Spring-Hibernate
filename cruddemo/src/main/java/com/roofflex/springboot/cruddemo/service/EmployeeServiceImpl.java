package com.roofflex.springboot.cruddemo.service;

import com.roofflex.springboot.cruddemo.dao.EmployeeDAO;
import com.roofflex.springboot.cruddemo.dao.EmployeeSpringDataJPARepository;
import com.roofflex.springboot.cruddemo.entity.Employee;
import com.roofflex.springboot.cruddemo.exceptionhandling.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // adding @Qualifier to support switching between Hibernate / JPA

    @Autowired
    @Qualifier("employeeDAOJPAImpl")  // or use employeeDAOJPAImpl
    private EmployeeDAO employeeDAO;


    @Override
    @Transactional
    public List<Employee> getEmployees() {
        return employeeDAO.getEmployees();
    }

    @Override
    @Transactional
    public Employee getSingleEmployee(int employeeId) {
        return employeeDAO.getSingleEmployee(employeeId);
    }

    @Override
    @Transactional
    public void createEmployee(Employee employee) {
        employeeDAO.createEmployee(employee);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }

    // Uncomment to use Spring Data JPA instead of Hibernate / JPA

//    // Using Spring Data JPA, no need of @Transactional - it's built-in
//
//    @Autowired
//    private EmployeeSpringDataJPARepository jpaRepository;
//
//    @Override
//    public List<Employee> getEmployees() {
//        return jpaRepository.findAll();
//    }
//
//    @Override
//    public Employee getSingleEmployee(int employeeId) {
//        Optional<Employee> result = jpaRepository.findById(employeeId);
//
//        Employee employee = null;
//
//        if (result.isPresent()){
//            employee = result.get();
//        } else {
//            throw new EmployeeNotFoundException("Employee with such Id - " + employeeId + " not found.");
//        }
//
//        return employee;
//    }
//
//    @Override
//    public void createEmployee(Employee employee) {
//        jpaRepository.save(employee);
//    }
//
//    @Override
//    public void updateEmployee(Employee employee) {
//        jpaRepository.save(employee);
//    }
//
//    @Override
//    public void deleteEmployee(int employeeId) {
//        jpaRepository.deleteById(employeeId);
//    }
}
