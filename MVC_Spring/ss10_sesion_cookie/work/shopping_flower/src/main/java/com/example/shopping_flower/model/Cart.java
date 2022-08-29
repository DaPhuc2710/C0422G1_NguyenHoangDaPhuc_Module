package com.example.shopping_flower.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Flower,Integer> flowers= new HashMap<>();

    public Cart() {
    }
    public Cart(Map<Flower, Integer> flowers) {
        this.flowers = flowers;
    }



    public Map<Flower, Integer> getFlowers() {
        return flowers;
    }

    public void setFlowers(Map<Flower, Integer> flowers) {
        this.flowers = flowers;
    }
}
