package com.example.work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FuramaController {
    @RequestMapping("/")
    public String goMainMenu(){
        return "/main_menu";
    }
}
