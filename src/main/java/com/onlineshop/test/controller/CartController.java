package com.onlineshop.test.controller;

import com.onlineshop.test.entity.Cart;
import com.onlineshop.test.service.CartService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public Cart add(@RequestParam String customer, @RequestParam Long productId) {
        return cartService.addToCart(customer, productId);
    }

    @GetMapping("/view")
    public Cart view(@RequestParam String customer) {
        return cartService.getCart(customer);
    }

    @PostMapping("/clear")
    public void clear(@RequestParam String customer) {
        cartService.clearCart(customer);
    }
}

