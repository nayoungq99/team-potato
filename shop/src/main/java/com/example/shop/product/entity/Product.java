package com.example.shop.product;


import com.example.shop.order.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name", length = 100)
    private String name;

    @Column(name = "product_price")
    private int price;

    @Column(name = "product_stock")
    private int stock;

    @Column(name = "product_ds", length = 500)
    private String description;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders = new ArrayList<>();

    public Product(String name, int price, int stock, String description) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description =description;
    }

    public void updateInfo(int price, int stock, String description){
        if(price > 0){
            this.price = price;
        }

        if(stock >= 0) {
            this.stock = stock;
        }

        if(description != null){
            this.description = description;
        }
    }

    public void setId(Long id) {

        this.id = id;
    }
}

