package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @RequestMapping("/")
    public String goList(Model model) {
        model.addAttribute("blogList", iBlogService.showList());
        return "/list";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("newBlog", new Blog());
        return "/create_page";
    }

    @PostMapping("/saveAddForm")
    public String saveAdd(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.add(blog);
        redirectAttributes.addFlashAttribute("Message", "Thêm mới thành công");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String goDelete(@RequestParam Integer id) {
        iBlogService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String goDetail(@RequestParam Integer id, Model model) {
        Optional<Blog> blog =  iBlogService.findById(id);
        model.addAttribute("theBlog",blog.get());
        return "/detail_page";
    }
    @GetMapping("/update")
    public String goUpdate(@RequestParam Integer id,Model model) {
        model.addAttribute("blog",iBlogService.findById(id).get());
        return "/update_page";
    }
    @PostMapping("/saveUpdateForm")
    public String saveUpdate (@ModelAttribute Blog blog, RedirectAttributes redirectAttributes ) {
        iBlogService.update(blog);
        redirectAttributes.addFlashAttribute("Message", "Sửa thành công");
        return "redirect:/";
    }
}
