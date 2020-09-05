package com.roofflex.springboot.cruddemo.dao;

import com.roofflex.springboot.cruddemo.entity.Employee;
import com.roofflex.springboot.cruddemo.exceptionhandling.EmployeeNotFoundException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getEmployees() {
        Session currentSession = entityManager.unwrap(Session.class);


        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee getSingleEmployee(int employeeId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Employee employee = currentSession.get(Employee.class, employeeId);

        // throwing an exception if Id is invalid
        if (employee == null){
            throw new EmployeeNotFoundException("Employee with such Id - " + employeeId + " not found.");
        }
        return employee;
    }

    @Override
    public void createEmployee(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);


        currentSession.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(employee);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query query = currentSession.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", employeeId);

        query.executeUpdate();

    }
}
