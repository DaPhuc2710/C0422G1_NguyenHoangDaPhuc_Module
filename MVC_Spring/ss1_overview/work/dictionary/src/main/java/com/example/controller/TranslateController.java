package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.service.IService;

@Controller
public class TranslateController {
    @Autowired
    private IService service;
    @GetMapping("/main")
    public String insertEnglish(@RequestParam String english, Model model) {
        String result= service.dictionary(english);
        if (result==null){
           model.addAttribute("result","File not found");
        }else {
            model.addAttribute("result",result);
        }
        model.addAttribute("english",english);
        return "index";
    }
}
