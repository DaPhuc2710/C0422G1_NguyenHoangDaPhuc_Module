package com.example.library.service;

import com.example.library.model.BookManager;

import java.util.List;

public interface ILibraryService {
    void borrowBook(int id);
    void payBack(int id);
    List<BookManager>findAll();
    BookManager findById(int id);
}
