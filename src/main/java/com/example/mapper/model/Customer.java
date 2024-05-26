package com.example.mapper.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Long customerId;

    private String firstName;

    private String lastName;

    private String email;

    private String contactNumber;

}
