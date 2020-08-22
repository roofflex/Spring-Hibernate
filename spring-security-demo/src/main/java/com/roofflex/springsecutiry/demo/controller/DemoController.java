package com.roofflex.springsecutiry.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showLanding(){
        return "landing-page";
    }

    @GetMapping("/employees")
    public String showHome(){
        return "home";
    }

    @GetMapping("/managers")
    public String showManagerPage(){
        return "manager-page";
    }

    @GetMapping("/admins")
    public String showAdminPage(){
        return "admin-page";
    }
}
