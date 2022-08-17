package com.example.service.impl;

import com.example.model.PageSize;
import com.example.repository.IPageSizeRepository;
import com.example.service.IPageSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageSizeService implements IPageSizeService {
    @Autowired
    private IPageSizeRepository iPageSizeRepository;

    @Override
    public List<PageSize> findAll() {
        return iPageSizeRepository.findAll();
    }
}
