package com.example.thirdpartyproductservice.services;

import com.example.thirdpartyproductservice.exceptions.ProductNotFoundException;
import com.example.thirdpartyproductservice.model.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws ProductNotFoundException;
    List<Product> getAllProduct();
    Product replaceProduct(Long id,Product product);
    //Product addProduct(Product product);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct();
}
