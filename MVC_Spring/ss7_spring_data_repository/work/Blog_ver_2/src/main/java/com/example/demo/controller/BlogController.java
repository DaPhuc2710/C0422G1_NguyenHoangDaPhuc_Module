package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @RequestMapping("/")
    public String goList(Model model, @PageableDefault(size = 3) Pageable pageable) {
        model.addAttribute("blogList", iBlogService.findAll(pageable));
        model.addAttribute("categories", iCategoryService.showList());
        return "/list";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("newBlog", new Blog());
        model.addAttribute("categories", iCategoryService.showList());
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
        Optional<Blog> blog = iBlogService.findById(id);
        model.addAttribute("theBlog", blog.get());
        return "/detail_page";
    }

    @GetMapping("/update")
    public String goUpdate(@RequestParam Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id).get());
        model.addAttribute("categories", iCategoryService.showList());
        return "/update_page";
    }

    @PostMapping("/saveUpdateForm")
    public String saveUpdate(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.update(blog);
        redirectAttributes.addFlashAttribute("Message", "Sửa thành công");
        return "redirect:/";
    }
}
