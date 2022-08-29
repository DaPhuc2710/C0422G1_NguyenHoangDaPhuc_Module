package com.example.shopping_flower.controller;

import com.example.shopping_flower.service.IFlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private IFlowerService iFlowerService;
    @RequestMapping("/")
    public String goCartBuy() {
        return "/cart/cart_buy";
    }

    @RequestMapping(value = "buy/{id}")
    public String buy(@PathVariable("id") int id, Model model, HttpSession session) {
        model.addAttribute("flowerList",iFlowerService.findAll());
        if (session.getAttribute("cart")==null){
            List<Items> cart= new ArrayList<>();
            cart.add(new Items(iFlowerService.findById(id),1));
            session.setAttribute("cart",cart);
        }else {

        }
        return "redirect:/cart_buy";
    }
}
