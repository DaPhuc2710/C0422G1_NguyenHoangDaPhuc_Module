package com.example.register_form.controller;

import com.example.register_form.dto.UserDto;
import com.example.register_form.model.User;
import com.example.register_form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

    @RequestMapping("/")
    public String goMainMenu(Model model) {
        model.addAttribute("userList", iUserService.findAll());
        return "/main_menu";
    }

    @GetMapping("/create")
    public String goToUserCreate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/create_form";
    }

    @PostMapping("/saveCreateForm")
    public String saveRegisterForm( @ModelAttribute @Valid UserDto userDto,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes,
                                   Model model) {
        if (bindingResult.hasErrors()) {

            return "/create_form";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        iUserService.save(user);
        redirectAttributes.addFlashAttribute("msg", "Register successfully!");
        return "redirect:/";
    }


}
