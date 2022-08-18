package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    static private List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Dầu ăn", "30000", "Việt Nam"));
        products.add(new Product(2, "Trứng gà", "35000", "Việt Nam"));
        products.add(new Product(3, "Nho Úc", "70000", "Úc"));
        products.add(new Product(4, "Táo", "60000", "Mỹ"));
        products.add(new Product(5, "Coca", "20000", "Việt Nam"));
        products.add(new Product(6, "Đường", "30000", "Việt Nam"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                product = products.get(i);
            }
        }
        return product;
    }

    @Override
    public void add(Product product) {
        int id = (int) (Math.random() * 1000);
        product.setId(id);
        products.add(product);

    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                products.remove(products.get(i));
            }
        }
    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (product.getId() == products.get(i).getId()) {
                products.get(i).setName(product.getName());
                products.get(i).setPrice(product.getPrice());
                products.get(i).setMadeIn(product.getMadeIn());
            }
        }
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().contains(name)) {
                productList.add(products.get(i));
            }
        }
        return productList;
    }
}
