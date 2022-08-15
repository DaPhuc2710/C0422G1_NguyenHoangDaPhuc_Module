package com.changemoney.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeMoney {
    @GetMapping("/main")
    public String changing(@RequestParam double soTienNhap, double rate, Model model) {
        double tienSauDo = soTienNhap * rate;
        model.addAttribute("soTienNhap", soTienNhap);
        model.addAttribute("tienSauDo", tienSauDo);
        model.addAttribute("rate", rate);
        return "index";
    }


}
