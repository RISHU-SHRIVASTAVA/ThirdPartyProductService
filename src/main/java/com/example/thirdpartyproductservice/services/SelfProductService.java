package com.example.thirdpartyproductservice.services;

import com.example.thirdpartyproductservice.exceptions.ProductNotFoundException;
import com.example.thirdpartyproductservice.model.Category;
import com.example.thirdpartyproductservice.model.Product;
import com.example.thirdpartyproductservice.repository.CategoryRepository;
import com.example.thirdpartyproductservice.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
@Primary
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        //Fetch the product with the given id from DB.
        return null;
    }
    @Override
    public List<Product> getAllProduct() {
        return null;
    }
    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }
    @Override
    public Product createProduct(Product product) {
        //Before saving the product object in the DB, save the category
        Category category=product.getCategory();

        if(category.getId() == null){
            Category savedCategory =categoryRepository.save(category);
            product.setCategory(savedCategory);
        }
        else {
            //check whether the id is present in category or not
        }
//        return productRepository.save(product);
        Product savedProduct =  productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(savedProduct.getCategory().getId());
        Category category1 = optionalCategory.get();
        savedProduct.setCategory(category1);
        return savedProduct;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }
    @Override
    public void deleteProduct() {

    }
}
