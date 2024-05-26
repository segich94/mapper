package com.example.mapper.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @ManyToMany
    private List<Product> products;

    private String orderDate;

    private String shippingAddress;

    private Double totalPrice;
    @Enumerated
    private Status status;
}