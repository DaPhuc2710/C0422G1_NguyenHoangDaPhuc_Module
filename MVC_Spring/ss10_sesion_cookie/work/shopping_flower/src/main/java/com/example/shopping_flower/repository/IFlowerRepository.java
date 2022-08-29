package com.example.shopping_flower.repository;

import com.example.shopping_flower.model.Flower;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IFlowerRepository extends PagingAndSortingRepository<Flower,Long> {
}
