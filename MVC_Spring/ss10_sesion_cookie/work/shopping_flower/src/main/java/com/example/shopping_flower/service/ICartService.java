package com.example.shopping_flower.service;

import com.example.shopping_flower.model.Cart;
import com.example.shopping_flower.model.Flower;

public interface ICartService {
    void addFlower(Flower flower, Cart cart);
    void subFlower(Flower flower, Cart cart);
    Integer countFlowerQuantity(Cart cart);
    Integer countItemQuantity(Cart cart);
    Float countTotalPayment(Cart cart);
}
