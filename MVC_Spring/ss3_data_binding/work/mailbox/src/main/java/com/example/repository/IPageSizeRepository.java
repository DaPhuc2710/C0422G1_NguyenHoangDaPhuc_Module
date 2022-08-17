package com.example.repository;

import com.example.model.PageSize;

import java.util.List;

public interface IPageSizeRepository {
    List<PageSize> findAll();
}
