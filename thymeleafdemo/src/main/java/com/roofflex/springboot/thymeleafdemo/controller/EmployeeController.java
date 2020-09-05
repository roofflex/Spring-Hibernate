package com.roofflex.springboot.thymeleafdemo.controller;


import com.roofflex.springboot.thymeleafdemo.entity.Employee;
import com.roofflex.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/hello")
    public String sayHello(Model theModel){
        theModel.addAttribute("theDate", new java.util.Date());
        return "helloworld";
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel){
        // populating the model with all employees fro database
        theModel.addAttribute("employees", employeeService.findAll());
        return "list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String addEmployee(Model theModel){
        Employee newEmployee = new Employee();

        theModel.addAttribute("employee", newEmployee);
        return "employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String updateEmployee(@RequestParam("employeeId") int employeeId, Model theModel){
        Employee employee = employeeService.findById(employeeId);

        theModel.addAttribute("employee", employee);
        return "employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        employeeService.save(theEmployee);

        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int employeeId){
        employeeService.deleteById(employeeId);

        return "redirect:/employees/list";
    }
}
