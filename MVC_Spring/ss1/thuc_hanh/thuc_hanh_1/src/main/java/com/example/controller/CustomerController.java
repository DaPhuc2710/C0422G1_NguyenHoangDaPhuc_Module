package com.example.controller;

import com.example.model.Customer;
import com.example.service.IServiceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class  CustomerController {


    @Autowired IServiceCustomer iServiceCustomer;

    @GetMapping("/")
    public String listCustomer(Model model){
        List<Customer> customerList = iServiceCustomer.findAll();
        model.addAttribute("customerList",customerList);
        return "/customer/list";
    }

}
