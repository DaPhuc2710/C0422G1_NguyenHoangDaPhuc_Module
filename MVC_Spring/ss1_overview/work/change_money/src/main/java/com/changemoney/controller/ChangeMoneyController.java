package com.changemoney.controller;

import com.changemoney.service.IChangeMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeMoneyController {
    @Autowired
    private IChangeMoneyService iService;

    @GetMapping("/main")
    public String changing(@RequestParam double inputMoney, double rate, Model model) {
        double afterChangeMoney = iService.calculator(inputMoney, rate);
        model.addAttribute("inputMoney", inputMoney);
        model.addAttribute("afterChangeMoney", afterChangeMoney);
        model.addAttribute("rate", rate);
        return "index";
    }
}
