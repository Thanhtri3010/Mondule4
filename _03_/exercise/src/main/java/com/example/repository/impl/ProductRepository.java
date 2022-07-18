package com.example.repository.impl;

import com.example.repository.IProductRepository;
import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone 11", "1100", "Mới", "Apple"));
        products.put(2, new Product(2, "S22UlTra", "1200", " Cũ", "SamSung"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> searchProduct(String name) {
        List<Product> searchList = new ArrayList<>();
        for (Product item : products.values()) {
            if (item.getProductName().contains(name)) {
                searchList.add(item);
            }
        }
        return searchList;
    }
}
