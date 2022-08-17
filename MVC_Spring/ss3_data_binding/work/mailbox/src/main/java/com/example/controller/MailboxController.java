package com.example.controller;

import com.example.model.Mailbox;
import com.example.service.ILanguageService;
import com.example.service.IPageSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailboxController {
    @Autowired
    private ILanguageService iLanguageService;
    @Autowired
    private IPageSizeService iPageSizeService;

    @RequestMapping("home")
    public String goHome(Model model) {
        model.addAttribute("langList", iLanguageService.findAll());
        model.addAttribute("pageList", iPageSizeService.findAll());
        model.addAttribute("mailbox", new Mailbox());
        return "setting";
    }

    @PostMapping("save")
    public String saveForm(@ModelAttribute("mailbox") Mailbox mailbox, Model model) {
        model.addAttribute("language", mailbox.getLanguage());
        model.addAttribute("pageSize", mailbox.getPageSize());
        model.addAttribute("spamFilter", mailbox.isSpamFilter());
        model.addAttribute("signature", mailbox.getSignature());
        return "saving";
    }
}
