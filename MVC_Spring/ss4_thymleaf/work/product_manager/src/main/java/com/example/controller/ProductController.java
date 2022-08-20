package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @RequestMapping("/")
    public String goList(Model model) {
        List<Product> productList = iProductService.findAll();
        model.addAttribute("productList", productList);
        return "/list";
    }

    @GetMapping("/delete")
    public String goDelete(@RequestParam int id, Model model) {
        iProductService.delete(id);
        model.addAttribute("productList", iProductService.findAll());
        return "redirect:/";

    }

    @GetMapping("/add")
    public String createP(Model model) {
        model.addAttribute("product", new Product());
        return "/adding";
    }

    @PostMapping("/saveCreate")
    public String saveCreateP(@ModelAttribute Product product, Model model) {
        iProductService.add(product);
        model.addAttribute("productList", iProductService.findAll());
        return "redirect:/";
    }

    @GetMapping("/byName")
    public String findName(@RequestParam String name, Model model) {
        List<Product> productList = iProductService.findByName(name);
        model.addAttribute("productList", productList);
        return "/list";
    }

    @GetMapping("/byId")
    public String findId(@RequestParam int id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("productList", product);
        return "/list";
    }

    @GetMapping("/editing")
    public String edit(@RequestParam int id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("product1", product);
        return "/edit";
    }

    @PostMapping("/saveEdit")
    public String saveEdit(@ModelAttribute Product product) {
        iProductService.update(product);
        return "redirect:/";
    }

    @GetMapping("/viewing")
    public String viewIn(@RequestParam int id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("product1", product);
        return "/view";
    }

}
