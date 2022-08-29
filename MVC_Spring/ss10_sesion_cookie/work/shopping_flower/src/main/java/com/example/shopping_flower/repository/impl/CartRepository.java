package com.example.shopping_flower.repository.impl;

import com.example.shopping_flower.model.Cart;
import com.example.shopping_flower.model.Flower;
import com.example.shopping_flower.repository.ICartRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CartRepository implements ICartRepository {
    private boolean checkItemInCart(Flower flower, Cart cart) {
        Map<Flower, Integer> flowers = cart.getFlowers();
        for (Map.Entry<Flower, Integer> entry : flowers.entrySet()) {
            if (entry.getKey().getId().equals(flower.getId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Flower, Integer> selectItemInCart(Flower flower, Cart cart) {
        Map<Flower, Integer> flowers = cart.getFlowers();
        for (Map.Entry<Flower, Integer> entry : flowers.entrySet()) {
            if (entry.getKey().getId().equals(flower.getId())) {
                return entry;
            }
        }
        return null;
    }


    @Override
    public void addFlower(Flower flower, Cart cart) {
        Map<Flower, Integer> flowers = cart.getFlowers();
        if (!checkItemInCart(flower, cart)) {
            flowers.put(flower, 1);
            cart.setFlowers(flowers);
        } else {
            Map.Entry<Flower, Integer> itemEntry = selectItemInCart(flower, cart);
            Integer newQuantity = itemEntry.getValue() + 1;
            flowers.replace(itemEntry.getKey(), newQuantity);
            cart.setFlowers(flowers);
        }

    }

    @Override
    public void subFlower(Flower flower, Cart cart) {
        Map<Flower, Integer> flowers = cart.getFlowers();
        if (!checkItemInCart(flower, cart)) {
            return;
        } else {
            Map.Entry<Flower, Integer> itemEntry = selectItemInCart(flower, cart);
            Integer newQuantity = itemEntry.getValue() - 1;
            flowers.replace(itemEntry.getKey(), newQuantity);
            cart.setFlowers(flowers);
        }

    }

    @Override
    public Integer countFlowerQuantity(Cart cart) {
        Map<Flower, Integer> flowers = cart.getFlowers();
        Integer flowerQuantity = 0;
        for (Map.Entry<Flower, Integer> entry : flowers.entrySet()) {
            flowerQuantity += entry.getValue();
        }
        return flowerQuantity;
    }

    @Override
    public Integer countItemQuantity(Cart cart) {
        return cart.getFlowers().size();
    }

    @Override
    public Float countTotalPayment(Cart cart) {
        Map<Flower, Integer> flowers = cart.getFlowers();
        float payment = 0;
        for (Map.Entry<Flower, Integer> entry : flowers.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}
