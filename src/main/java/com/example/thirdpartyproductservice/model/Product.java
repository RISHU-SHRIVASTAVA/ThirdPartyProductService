package com.example.thirdpartyproductservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private String description;
    private double price;
    private String image;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private Category category;
    private int qty;
    private int numberOfOrders;
}

/*
  1      ->         1
Product -------- Category ==> M:1
  M          <-     1
==========================
   M               1

  1                 M
Movie ------------ Actor ==> M:M
  M                  1


 */