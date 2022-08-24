package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String artist;
    private String name;
    private String content;
    private String age;
    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false, referencedColumnName = "id_category")
    private Category category;

    public Blog() {
    }

    public Blog(Integer id, String artist, String name, String content, String age, Category category) {
        this.id = id;
        this.artist = artist;
        this.name = name;
        this.content = content;
        this.age = age;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
