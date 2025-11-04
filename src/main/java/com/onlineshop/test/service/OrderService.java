package com.onlineshop.test.service;

import com.onlineshop.test.entity.Cart;
import com.onlineshop.test.entity.Order;
import com.onlineshop.test.entity.Product;
import com.onlineshop.test.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class OrderService {

    @Autowired
    private CartService cartService;
    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private NotificationService notificationService;

    public Order checkout(String customer) {
        Cart cart = cartService.getCart(customer);
        double total = cart.getProducts().stream().mapToDouble(Product::getPrice).sum();

        if (paymentService.processPayment(customer, total)) {
            Order order = new Order();
            order.setCustomer(customer);
            order.setCreatedAt(LocalDateTime.now());
            order.setProducts(new ArrayList<>(cart.getProducts()));
            orderRepo.save(order);

            cartService.clearCart(customer);
            notificationService.notifyCustomer(customer, "Ваш заказ оформлен. Сумма: $" + total);
            return order;
        } else {
            throw new RuntimeException("Ошибка оплаты");
        }
    }
}

