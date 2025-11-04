package com.onlineshop.test.service;

import com.onlineshop.test.entity.Cart;
import com.onlineshop.test.entity.Product;
import com.onlineshop.test.repository.CartRepository;
import com.onlineshop.test.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepo;
    @Autowired
    private ProductRepository productRepo;

    public Cart addToCart(String customer, Long productId) {
        Cart cart = cartRepo.findByCustomer(customer).orElse(new Cart());
        cart.setCustomer(customer);
        Product product = productRepo.findById(productId).orElseThrow();
        cart.getProducts().add(product);
        return cartRepo.save(cart);
    }

    public Cart getCart(String customer) {
        return cartRepo.findByCustomer(customer).orElseThrow();
    }

    public void clearCart(String customer) {
        Cart cart = cartRepo.findByCustomer(customer).orElseThrow();
        cart.getProducts().clear();
        cartRepo.save(cart);
    }
}

