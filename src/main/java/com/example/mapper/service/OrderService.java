package com.example.mapper.service;

import com.example.mapper.model.Order;

public interface OrderService {
    Order createOrder(Order order);
    Order getOrder(Long id);
}
