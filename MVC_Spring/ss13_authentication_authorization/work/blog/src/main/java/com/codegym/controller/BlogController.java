package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @RequestMapping("/blogList")
    public String goList(Model model,
                         @RequestParam(required = false, defaultValue = "") String search,
                         @RequestParam(required = false, defaultValue = "0") Integer category,
                         @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.ASC) Pageable pageable, Principal principal) {
        Category categoryServiceById = iCategoryService.findById(category);
        Page<Blog> page = iBlogService.findAll(pageable, search, categoryServiceById);
        model.addAttribute("list", page);
        model.addAttribute("pageable", pageable);
        model.addAttribute("categoryList", iCategoryService.showList());
        model.addAttribute("search", search);
        model.addAttribute("category", iCategoryService.findById(category));
        model.addAttribute("cately", category);
        User user = (User) ((Authentication) principal).getPrincipal();
        for (GrantedAuthority a : user.getAuthorities()) {
            if (a.getAuthority().equals("ROLE_ADMIN")) {
                model.addAttribute("admin", "ADMIN");
            }
        }

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
        redirectAttributes.addFlashAttribute("Message", "Th??m m???i th??nh c??ng");
        return "redirect:/blogList";
    }

    @GetMapping("/delete")
    public String goDelete(@RequestParam Integer id) {
        iBlogService.delete(id);
        return "redirect:/blogList";
    }

    @GetMapping("/detail")
    public String goDetail(@RequestParam Integer id, Model model) {
        model.addAttribute("theBlog", iBlogService.findById(id).get());
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
        redirectAttributes.addFlashAttribute("Message", "S???a th??nh c??ng");
        return "redirect:/blogList";
    }

    @GetMapping("/search")
    public String letSearch() {
        return null;
    }
}
