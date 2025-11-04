package com.onlineshop.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Cart {

    @Id
    @GeneratedValue
    private Long id;

    private String customer;

    @ManyToMany
    private List<Product> products = new ArrayList<>();

    // геттеры и сеттеры
}

