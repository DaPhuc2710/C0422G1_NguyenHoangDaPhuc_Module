package com.example.service.impl;

import com.example.repository.IRepository;
import com.example.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
@org.springframework.stereotype.Service
public class Service implements IService {
    @Autowired
     private IRepository iRepository;

    @Override
    public String dictionary(String word) {
      return  iRepository.dictionary(word);
    }
}
