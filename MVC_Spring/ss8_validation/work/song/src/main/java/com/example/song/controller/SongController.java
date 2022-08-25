package com.example.song.controller;

import com.example.song.dto.SongDto;
import com.example.song.model.Song;
import com.example.song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
@Controller
public class SongController {
    @Autowired
    private ISongService iSongService;

    @RequestMapping("/")
    public String goToList(Model model) {
        model.addAttribute("songList", iSongService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String goToCreate(Model model) {
        model.addAttribute("newSongDto", new SongDto());
        return "/create_page";
    }

    @PostMapping("/saveForm")
    public String saveForm1(@ModelAttribute("newSongDto") @Valid SongDto songDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           Model model) {
        Song song = new Song();
        if (bindingResult.hasErrors()) {
            return "/create_page";
        }
        BeanUtils.copyProperties(songDto,song);
        iSongService.save(song);
        redirectAttributes.addFlashAttribute("msg", "Đã thêm thành công");
        return "redirect:/";
    }

}
