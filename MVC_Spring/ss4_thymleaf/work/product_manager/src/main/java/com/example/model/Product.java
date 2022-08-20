package com.example.model;

public class Product {
    private int id;
    private String name;
    private String price;
    private String madeIn;

    public Product() {
    }

    public Product(int id, String name, String price, String madeIn) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.madeIn = madeIn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }
}
