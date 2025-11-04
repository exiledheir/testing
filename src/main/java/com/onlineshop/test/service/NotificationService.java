package com.onlineshop.test.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void notifyCustomer(String customer, String message) {
        System.out.println("Уведомление для " + customer + ": " + message);
    }
}

