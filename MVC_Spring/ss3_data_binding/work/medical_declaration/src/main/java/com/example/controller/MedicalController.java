package com.example.controller;

import com.example.model.MedicalReport;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MedicalController {
    @Autowired
    private IBirthYearService iBirthYearService;
    @Autowired
    private IDateService iDateService;
    @Autowired
    private IGenderService iGenderService;
    @Autowired
    private INationalityService iNationalityService;
    @Autowired
    private ITransportService iTransportService;
    @Autowired
    private IMedicalReportService iMedicalReportService;

    @GetMapping("/")
    public String goHome(Model model) {
        model.addAttribute("medical", iMedicalReportService.findAll());
        return "home";
    }

    @RequestMapping("goEdit")
    public String goEdit(Model model) {
        return "edit";
    }

    @RequestMapping("goCreate")
    public String goCreate(Model model) {
        model.addAttribute("medical", new MedicalReport());
        model.addAttribute("birthYear", iBirthYearService);
        model.addAttribute("date", iDateService);
        model.addAttribute("gender", iGenderService);
        model.addAttribute("nationality", iNationalityService);
        model.addAttribute("transport", iTransportService);
        return "create";
    }
}
