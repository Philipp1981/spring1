package com.geekbrains.spring_demo4.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="products_2")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name = "price")
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(Long id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price=price;
    }

    public Product() {
    }

}
