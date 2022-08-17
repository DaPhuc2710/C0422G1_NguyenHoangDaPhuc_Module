package com.example.controller;

import com.example.model.Mailbox;
import com.example.service.ILanguageService;
import com.example.service.IMailboxService;
import com.example.service.IPageSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailboxController {
    @Autowired
    private ILanguageService iLanguageService;
    @Autowired
    private IPageSizeService iPageSizeService;
    @Autowired
    private IMailboxService mailboxService;

    @GetMapping("/home")
    public String goHome(Model model) {
        model.addAttribute("mailbox", new Mailbox());
        model.addAttribute("langList", iLanguageService.findAll());
        model.addAttribute("pageList", iPageSizeService.findAll());
        return "/create";
    }

    @PostMapping("/save")
    public String saveForm(@ModelAttribute Mailbox mailbox, Model model) {
        mailboxService.save(mailbox);
        Mailbox mailbox1 = mailboxService.findAll();
        model.addAttribute("mailBox1", mailbox1);
        return "/list";
    }
}
