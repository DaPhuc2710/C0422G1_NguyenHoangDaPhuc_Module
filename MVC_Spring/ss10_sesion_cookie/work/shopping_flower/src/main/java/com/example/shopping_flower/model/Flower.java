package com.example.shopping_flower.model;

import javax.persistence.*;

@Entity
@Table(name = "flower")
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private String name;
    @Column(columnDefinition = "VARCHAR(255)")
    private String link;
    private String description;

    public Flower() {
    }

    public Flower(Long id, double price, String name, String link, String description) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.link = link;
        this.description = description;
    }

    public Flower(double price, String name, String link, String description) {
        this.price = price;
        this.name = name;
        this.link = link;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
