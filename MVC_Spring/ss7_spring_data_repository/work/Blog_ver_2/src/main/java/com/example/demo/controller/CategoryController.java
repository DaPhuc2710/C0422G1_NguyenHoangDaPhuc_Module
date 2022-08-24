package com.example.demo.controller;

import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/categories")
    public String goList(Model model) {
        model.addAttribute("categoryList", iCategoryService.showList());
        return "/category_list";
    }
}
