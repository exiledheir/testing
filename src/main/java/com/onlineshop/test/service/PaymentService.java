package com.onlineshop.test.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public boolean processPayment(String customer, double amount) {
        System.out.println("Оплата от " + customer + " на сумму $" + amount);
        return true;
    }
}

