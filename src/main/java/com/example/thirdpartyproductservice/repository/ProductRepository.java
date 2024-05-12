package com.example.thirdpartyproductservice.repository;

import com.example.thirdpartyproductservice.model.Product;
import com.example.thirdpartyproductservice.projection.ProductWithTitleAndDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long id);

    Optional<Product> findByTitle(String word);

//    List<Product> findByTitle(String word);

    List<Product> findByTitleContains(String str);

    Optional<Product> findByImage(String url);
    @Override
    void delete(Product entity);

    Product save(Product product); // create and update

    //HQL
    @Query("select p.title, p.description from Product p where p.id = :id")
    Product someRandomQuery(@Param("id") Long id);

    //HQL
    @Query("select p.title as title, p.description as description from Product p where p.id = :id")
    ProductWithTitleAndDescription someeRandomQuery(@Param("id") Long id);

    //SQL Query -> native query
    @Query(value = "select title, description from product where id = :id", nativeQuery = true)
    ProductWithTitleAndDescription someOtherRandomQuery(@Param("id") Long id);



}