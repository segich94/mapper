package com.example.mapper.service;

import com.example.mapper.model.Order;
import com.example.mapper.model.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    OrderRepository orderRepository;
    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    @Transactional(readOnly = true)
    public Order getOrder(Long id) {
        return orderRepository.findById(id).get();
    }
}
