package com.example.service.impl;

import com.example.repository.IDictionaryRepository;
import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
@org.springframework.stereotype.Service
public class DictionaryService implements IDictionaryService {
    @Autowired
     private IDictionaryRepository iRepository;

    @Override
    public String dictionary(String word) {
      return  iRepository.dictionary(word);
    }
}
