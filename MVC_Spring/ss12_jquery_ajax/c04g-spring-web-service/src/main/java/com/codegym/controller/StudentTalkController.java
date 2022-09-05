package com.codegym.controller;

import com.codegym.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@RequestMapping(value = "/talk")
@Controller
public class StudentTalkController {

    @GetMapping(value = "/list")
    public String goTalkList(@SessionAttribute List<Student> talkList,
                             Model model) {

        model.addAttribute("talkList", talkList);

        return "list_student_talk";
    }
}
