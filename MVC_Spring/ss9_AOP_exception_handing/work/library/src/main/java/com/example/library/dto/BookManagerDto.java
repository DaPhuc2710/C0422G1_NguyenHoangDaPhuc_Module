package com.example.library.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BookManagerDto {
    private int id;
    @NotEmpty
    @NotBlank(message = "không được để trống")
    private String name;
    @NotEmpty
    @NotBlank(message = "không được để trống")
    private String bookCode;
    @NotEmpty
    @NotBlank(message = "không được để trống")
    private String quantity;
    private String author;
    @NotEmpty
    @NotBlank(message = "không được để trống")
    private String category;
    @NotNull
    private int total;
    @NotNull
    private int remaining;

    public BookManagerDto(int id, String name, String bookCode,  String author, String category, int total, int remaining) {
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
