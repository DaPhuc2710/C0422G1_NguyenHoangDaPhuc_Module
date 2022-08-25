package com.example.product_manager.controller;

import com.example.product_manager.model.Product;
import com.example.product_manager.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String findId(@RequestParam Integer id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("productList", product);
        return "/list";
    }

    @GetMapping("/editing")
    public String edit(@ModelAttribute Integer id, Model model) {
        iProductService.findById(id);
        model.addAttribute("product", iProductService.findById(id));
        return "/edit";
    }

    @PostMapping("/saveEdit")
    public String saveEdit(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iProductService.update(product);
        redirectAttributes.addFlashAttribute("msg", "Sửa thành công");
        return "redirect:/";
    }

    @GetMapping("/viewing")
    public String viewIn(@RequestParam Integer id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("product1", product);
        return "/view";
    }

}
