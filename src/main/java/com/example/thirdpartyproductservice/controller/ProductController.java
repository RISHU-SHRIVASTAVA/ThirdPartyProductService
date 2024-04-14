package com.example.thirdpartyproductservice.controller;

import com.example.thirdpartyproductservice.exceptions.ProductNotFoundException;
import com.example.thirdpartyproductservice.model.Product;
import com.example.thirdpartyproductservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    /*@GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return  productService.getProductById(id);
    }*/
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        Product product=productService.getProductById(id);
//        if(product==null){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProduct();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return  productService.replaceProduct(id,product);
    }
   /* @PostMapping()
    public Product addProduct(@RequestBody Product product){
         return productService.addProduct(product);
    }*/

    //create product
    //delete product
    //update product -> partial Update (PATCH)
    //replace product -> Replace (PUT)

    @PostMapping
    public  Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

}
