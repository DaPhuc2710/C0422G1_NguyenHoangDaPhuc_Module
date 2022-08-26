package com.example.library.model;

import javax.persistence.*;

@Entity
@Table(name = "library")
public class BookManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String bookCode;
    private String author;
    private String category;
    private int total;
    private int remaining;

    public BookManager() {
    }


    public BookManager(int id, String name, String bookCode, String author, String category, int total, int remaining) {
        this.id = id;
        this.name = name;
        this.bookCode = bookCode;

        this.author = author;
        this.category = category;
        this.total = total;
        this.remaining = remaining;
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

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }
}
