package com.example.shopping_flower.controller;

import com.example.shopping_flower.model.Cart;
import com.example.shopping_flower.model.Flower;
import com.example.shopping_flower.service.ICartService;
import com.example.shopping_flower.service.IFlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@SessionAttributes("cart")
public class FlowerController {
    @Autowired
    private IFlowerService iFlowerService;
    @Autowired
    private ICartService iCartService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @RequestMapping("/")
    public String goMenu(Model model) {
        model.addAttribute("flowerList", iFlowerService.findAll());
        return "/menu";
    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Flower> flowerOptional = iFlowerService.findById(id);
        if (!flowerOptional.isPresent()) {
            return "/error-404";
        }
        if (action.equals("show")) {
            this.iCartService.addFlower(flowerOptional.get(), cart);
            return "redirect:/shopping-cart";
        }
        if (action.equals("sub")) {
            this.iCartService.subFlower(flowerOptional.get(), cart);
            return "redirect:/shopping-cart";
        }
        this.iCartService.addFlower(flowerOptional.get(), cart);
        return "redirect:/";
    }

    @GetMapping(value = "/detail/{id}")
    public String showDetail(@PathVariable Long id,
                             Model model) {
        Optional<Flower> flowerOptional = iFlowerService.findById(id);
        model.addAttribute("flowerObj", flowerOptional.get());
        return "/detail";
    }

}
