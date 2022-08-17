package com.example.controller;

import com.example.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService iService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/calculate")
    public String goHome(String num1,String num2,String operator,Model model){
         String result=iService.calculate(num1,num2,operator);
        model.addAttribute("result",result);
        return  "/index";
    }

}
