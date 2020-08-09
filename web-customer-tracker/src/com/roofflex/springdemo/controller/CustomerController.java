package com.roofflex.springdemo.controller;

import com.roofflex.springdemo.dao.CustomerDAO;
import com.roofflex.springdemo.entity.Customer;
import com.roofflex.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // need to inject customer dao
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel){

        // get customers from the dao
        List<Customer> customers = customerService.getCustomers();

        // add the customers to the model
        theModel.addAttribute("customers", customers);
        return "list-customers";
    }

    // show the Customer form for adding Customer

    @GetMapping("/showFormForAdd")
    public String showCustomerForm(Model theModel){

        // create Model attribute to bind data
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){

        // save the customer using our service
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String updateCustomer(@RequestParam("customerId") int customerId, Model theModel){

        // get the customer from the database
        Customer theCustomer = customerService.getCustomer(customerId);

        // set customer as a model attribute to pre-populate the form
        theModel.addAttribute("customer", theCustomer);

        // send over to form
        return "customer-form";

    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int customerId){

        // delete customer by id
        customerService.deleteCustomer(customerId);
        // redirect to customers list
        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchForCustomer(@RequestParam("theSearchName") String searchName, Model theModel){

        // retrieve a list of customers with matching First/Last name
        List<Customer> matchingCustomers = customerService.getMatchingCustomers(searchName);

        // add customers to the model
        theModel.addAttribute("customers", matchingCustomers);

        return "list-customers";
    }
}
