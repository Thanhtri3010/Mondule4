package vn.codegym.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Product;
import vn.codegym.repository.IProductRepository;
import vn.codegym.service.IProductService;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        iProductRepository.update(id, product);
    }

    @Override
    public void remove(int id) {
        iProductRepository.remove(id);
    }

    @Override
    public List<Product> searchProduct(String name) {
        return iProductRepository.searchProduct(name);
    }
}
