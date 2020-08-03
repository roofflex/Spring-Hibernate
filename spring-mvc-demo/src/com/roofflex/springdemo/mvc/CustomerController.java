package com.roofflex.springdemo.mvc;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // add initbinder to convert trim input Strings
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){

        // Spring API has a built-in String editor that trims whitespaces before and after
        //             the arg true means that all-whitespace Strings are converted to null
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

        // This method is to learn pre-processing code, you can solve the whitespace validation issue with @NotBlank
    }

    @RequestMapping("/showForm")
    public String showForm(Model theModel){
        theModel.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "customer-form";
        } else{
            return "customer-confirmation";
        }
    }

}
