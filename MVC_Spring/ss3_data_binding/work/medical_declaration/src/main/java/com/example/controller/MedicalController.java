package com.example.controller;

import com.example.model.MedicalReport;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String gohome(Model model) {
        model.addAttribute("medicalReportService", iMedicalReportService.findAll());
        return "home";
    }
}
