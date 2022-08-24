package com.example.controller;

import com.example.model.MusicApp;
import com.example.service.IMusicAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MusicAppController {
    @Autowired
    IMusicAppService iMusicAppService;

    @RequestMapping("/")
    public String goList(Model model) {
        model.addAttribute("musicAppList", iMusicAppService.findAll());
        return "/list";
    }

    @GetMapping("/createObj")
    public String goCreateForm(Model model) {
        model.addAttribute("musicApp", new MusicApp());
        return "/create";
    }

    @PostMapping("/saveAdd")
    public String goSaveCreate(@ModelAttribute MusicApp musicApp) {
        iMusicAppService.create(musicApp);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String goDelete(@RequestParam int id, Model model) {
        iMusicAppService.delete(id);
        model.addAttribute("musicAppList", iMusicAppService.findAll());
        return "redirect:/";
    }

    @GetMapping("/editing")
    public String goEditForm(@RequestParam int id, Model model) {
        MusicApp musicApp = iMusicAppService.findById(id);
        model.addAttribute("musicApp1",musicApp);
        return "/edit";
    }
    @PostMapping("/saveEdit")
    public String goSaveEdit(@ModelAttribute MusicApp musicApp) {
        iMusicAppService.update(musicApp);
        return "redirect:/";
    }
}
