package com.example.controller;

import com.example.model.*;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
        return "/home";
    }

    @GetMapping("/goEdit")
    public String goEdit(@RequestParam int id, Model model) {
        MedicalReport medicalReport = iMedicalReportService.findId(id);
        List<BirthYear> birthYearList = iBirthYearService.findAll();
        List<Gender> genders = iGenderService.findAll();
        List<Nationality> nationalities = iNationalityService.findAll();
        List<Transport> transports = iTransportService.findAll();
        List<String> days = iDateService.findDayAll();
        List<String> months = iDateService.findMonthAll();
        List<String> years = iDateService.findYearAll();
        model.addAttribute("medical", new MedicalReport());
        model.addAttribute("medicalReport", medicalReport);
        model.addAttribute("birthYear", birthYearList);
        model.addAttribute("gender", genders);
        model.addAttribute("nationality", nationalities);
        model.addAttribute("transport", transports);
        model.addAttribute("days", days);
        model.addAttribute("months", months);
        model.addAttribute("years", years);
        return "/edit";
    }

    @GetMapping("/goCreate")
    public String goCreate(Model model) {
        List<BirthYear> birthYearList = iBirthYearService.findAll();
        List<Gender> genders = iGenderService.findAll();
        List<Nationality> nationalities = iNationalityService.findAll();
        List<Transport> transports = iTransportService.findAll();
        List<String> days = iDateService.findDayAll();
        List<String> months = iDateService.findMonthAll();
        List<String> years = iDateService.findYearAll();
        model.addAttribute("medical", new MedicalReport());
        model.addAttribute("birthYear", birthYearList);
        model.addAttribute("gender", genders);
        model.addAttribute("nationality", nationalities);
        model.addAttribute("transport", transports);
        model.addAttribute("days", days);
        model.addAttribute("months", months);
        model.addAttribute("years", years);
        return "/create";
    }
}
