package com.example.library.service.impl;

import com.example.library.model.BookManager;
import com.example.library.repository.ILibraryRepository;
import com.example.library.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService implements ILibraryService {
    @Autowired
    private ILibraryRepository iLibraryRepository;

    @Override
    public void borrowBook(int id) {
        iLibraryRepository.borrowBook(id);
    }

    @Override
    public void payBack(int id) {
        iLibraryRepository.payBack(id);
    }

    @Override
    public List<BookManager> findAll() {
        return iLibraryRepository.findAll();
    }

    @Override
    public BookManager findById(int id) {
        return iLibraryRepository.getById(id);
    }
}
