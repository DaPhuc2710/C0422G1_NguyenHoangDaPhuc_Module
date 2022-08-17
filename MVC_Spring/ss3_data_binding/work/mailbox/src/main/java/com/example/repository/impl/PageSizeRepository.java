package com.example.repository.impl;

import com.example.model.PageSize;
import com.example.repository.IPageSizeRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class PageSizeRepository implements IPageSizeRepository {
    static public List<PageSize> pageSizeList = new ArrayList<>();

    static {
        pageSizeList.add(new PageSize(5));
        pageSizeList.add(new PageSize(10));
        pageSizeList.add(new PageSize(15));
        pageSizeList.add(new PageSize(25));
        pageSizeList.add(new PageSize(50));
        pageSizeList.add(new PageSize(100));
    }

    @Override
    public List<PageSize> findAll() {
        return pageSizeList;
    }
}
