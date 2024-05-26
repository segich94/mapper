package com.example.mapper.service;

import com.example.mapper.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    Product getProduct(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}
