package com.roofflex.springdemo.dao;

import com.roofflex.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // need to inject session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        // get the current session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query, sort by last name
        Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);

        // execute query and get result list
        List<Customer> customers = query.getResultList();

        // return the result
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save customer
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int customerId) {

        // get the current Hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // find customer with specified id and return him
        Customer customer = currentSession.get(Customer.class, customerId);
        return customer;
    }

    @Override
    public void deleteCustomer(int customerId) {
        // get the current session
        Session currentSession = sessionFactory.getCurrentSession();

        // get the customer that we try to delete
        Customer tempCustomer = getCustomer(customerId);

        // delete the customer
        currentSession.delete(tempCustomer);
    }

    @Override
    public List<Customer> getMatchingCustomers(String searchName) {
        // get current session
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Customer> query = null;
        // create query for searching and return list of Customers
        if (searchName != null && searchName.trim().length() > 0) {

            // search for matching customers only if the seach text field is not blank, else return all customers
            // 'like' instead of '=' and lower() make search case-insensitive and can search for just a part of the name
            query = currentSession.createQuery("from Customer where lower(firstName) like" +
                    " :theSearchName or lower(lastName) like :theSearchName", Customer.class);
            query.setParameter("theSearchName", "%" + searchName.toLowerCase() + "%");
        } else{
            query = currentSession.createQuery("from Customer", Customer.class);
        }

        // retrieve customers
        List<Customer> customers = query.getResultList();
        return customers;
    }
}
