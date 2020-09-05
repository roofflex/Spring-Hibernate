package com.roofflex.springboot.cruddemo.dao;

import com.roofflex.springboot.cruddemo.entity.Employee;
import com.roofflex.springboot.cruddemo.exceptionhandling.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getEmployees() {

        Query query = entityManager.createQuery("from Employee");
        return query.getResultList();
    }

    @Override
    public Employee getSingleEmployee(int employeeId) {

        Employee employee = entityManager.find(Employee.class, employeeId);

        // throwing an exception if Id is invalid
        if (employee == null){
            throw new EmployeeNotFoundException("Employee with such Id - " + employeeId + " not found.");
        }
        return employee;
    }

    @Override
    public void createEmployee(Employee employee){

        entityManager.persist(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {

        entityManager.merge(employee);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", employeeId);

        query.executeUpdate();

    }
}
