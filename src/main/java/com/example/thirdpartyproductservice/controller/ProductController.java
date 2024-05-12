package com.example.thirdpartyproductservice.controller;

import com.example.thirdpartyproductservice.commons.AuthCommons;
import com.example.thirdpartyproductservice.dtos.UserDTO;
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
    private AuthCommons authCommons;

    public ProductController(@Qualifier("selfProductService") ProductService productService,
                             AuthCommons authCommons) {
        this.productService = productService;
        this.authCommons = authCommons;
    }


    /*@GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return  productService.getProductById(id);
    }*/
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id,
                                                  @RequestHeader("auth") String token) throws ProductNotFoundException {
        UserDTO userDTO=authCommons.validateToken(token);
        ResponseEntity<Product> responseEntity;
        if(userDTO ==null){
            responseEntity= new ResponseEntity<>(null,HttpStatus.FORBIDDEN);
            return responseEntity;
        }
        Product product=productService.getProductById(id);
        responseEntity=new ResponseEntity<>(product,HttpStatus.OK);

        //Role Based Access.
//        for (Role role : userDto.getRoles()) {
//            if (role.getValue().equals("ADMIN")) {
//                //provide access.
//            }
//        }

        //Call UserService Validate Token API to validate the token
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
