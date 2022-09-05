package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Integer idCate;
    @Column(name = "category_name")
    private String cateName;
    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Blog> blogs;

    public Category() {
    }
    public Category(Integer idCate, String cateName, List<Blog> blogs) {
        this.idCate = idCate;
        this.cateName = cateName;
        this.blogs = blogs;
    }

    public Integer getIdCate() {
        return idCate;
    }

    public void setIdCate(Integer idCate) {
        this.idCate = idCate;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
