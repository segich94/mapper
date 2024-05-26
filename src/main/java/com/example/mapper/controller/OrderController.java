package com.example.mapper.controller;

import com.example.mapper.model.Order;
import com.example.mapper.model.Product;
import com.example.mapper.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final ObjectMapper objectMapper;
    @PostMapping("/new")
    public String createOrder(@RequestBody String json){
        try {
            Order order = objectMapper.readValue(json, Order.class);
            orderService.createOrder(order);
            return "success" + order.getOrderId();
        }catch (JsonProcessingException e){
            return "json error";
        }
    }
    @GetMapping("/{id}")
    public String getOrder(@PathVariable Long id){
        try {
            return objectMapper.writeValueAsString(orderService.getOrder(id));
        }catch (JsonProcessingException e){
            return "error";
        }
    }

}
