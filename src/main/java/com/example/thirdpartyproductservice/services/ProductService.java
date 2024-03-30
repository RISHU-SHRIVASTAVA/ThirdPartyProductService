package com.example.thirdpartyproductservice.services;

import com.example.thirdpartyproductservice.model.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProduct(Long id);
    Product replaceProduct(Long id,Product product);
}
