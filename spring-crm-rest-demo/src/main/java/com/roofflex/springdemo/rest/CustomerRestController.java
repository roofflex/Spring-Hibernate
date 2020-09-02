package com.roofflex.springdemo.rest;


import com.roofflex.springdemo.entity.Customer;
import com.roofflex.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getSingleCustomer(@PathVariable int customerId){
        Customer customer = customerService.getCustomer(customerId);
        if (customer == null){
            throw new CustomerNotFoundException("Customer not found. Invalid id - " + customerId);
        }
        return customer;
    }


    // adding a customer with POST method

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){

        // we have to set id to 0 because Hibernate saveOrUpdate method is used, and to INSERT a new customer the id should be null/0
        customer.setId(0);

        customerService.saveCustomer(customer);

        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){

        // since the Id is specified in the request body, Hibernate will perform an Update
        customerService.saveCustomer(customer);

        return customer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){

        Customer customer = customerService.getCustomer(customerId);

        if (customer == null){
            throw new CustomerNotFoundException("Customer not found. Invalid id - " + customerId);
        }

        customerService.deleteCustomer(customerId);

        return "Customer deleted successfully!";
    }

}
