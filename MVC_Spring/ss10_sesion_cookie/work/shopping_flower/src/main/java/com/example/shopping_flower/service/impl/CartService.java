package com.example.shopping_flower.service.impl;

import com.example.shopping_flower.model.Cart;
import com.example.shopping_flower.model.Flower;
import com.example.shopping_flower.repository.ICartRepository;
import com.example.shopping_flower.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository iCartRepository;

    @Override
    public void addFlower(Flower flower, Cart cart) {
        iCartRepository.addFlower(flower, cart);
    }

    @Override
    public void subFlower(Flower flower, Cart cart) {
        if (this.iCartRepository.countItemQuantity(cart) == 0) {
            return;
        }
        this.iCartRepository.subFlower(flower, cart);

    }

    @Override
    public Integer countFlowerQuantity(Cart cart) {
        return iCartRepository.countFlowerQuantity(cart);
    }

    @Override
    public Integer countItemQuantity(Cart cart) {
        return iCartRepository.countItemQuantity(cart);
    }

    @Override
    public Float countTotalPayment(Cart cart) {
        return iCartRepository.countTotalPayment(cart);
    }
}
