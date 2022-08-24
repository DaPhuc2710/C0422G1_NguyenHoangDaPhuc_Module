package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/")
    public String findByName(Model model, @RequestParam(defaultValue = "") String name,
                             @PageableDefault(size = 4, sort = "name", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("productList", iProductService.findByName(name, pageable));
        model.addAttribute("name", name);
        return "/list";
    }

    @GetMapping("/add")
    public String createP(Model model) {
        model.addAttribute("product", new Product());
        return "/adding";
    }

    @PostMapping("/saveCreate")
    public String saveCreateP(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iProductService.add(product);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/";
    }

    @GetMapping("/byId")
    public String findId(@RequestParam int id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("productList", product);
        return "/list";
    }

    @GetMapping("/editing")
    public String edit(@ModelAttribute int id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("product1", product);
        return "/edit";
    }

    @PostMapping("/saveEdit")
    public String saveEdit(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iProductService.update(product);
        redirectAttributes.addFlashAttribute("msg", "Sửa thành công");
        return "redirect:/";
    }

    @GetMapping("/viewing")
    public String viewIn(@RequestParam int id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("product1", product);
        return "/view";
    }

}
