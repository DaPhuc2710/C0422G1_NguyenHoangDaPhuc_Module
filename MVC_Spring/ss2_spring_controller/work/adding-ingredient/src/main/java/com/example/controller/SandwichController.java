package com.example.controller;

import com.example.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @Autowired
    private IService iService;

    @GetMapping("/")
    public String goIndex(Model model) {
        model.addAttribute("list",iService.findAll());
        return "/showList";
    }
    @PostMapping("/result")
    public  String sendList(@RequestParam("condiment") String [] condiment, Model model){
        model.addAttribute("condiment",condiment);
        model.addAttribute("list",iService.findAll());
        return "/showList";
    }

}
