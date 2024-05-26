package com.example.mapper.controller;

import com.example.mapper.model.Product;
import com.example.mapper.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ObjectMapper objectMapper;
    @GetMapping
    public String getAllProduct(){
        try {
            return objectMapper.writeValueAsString(productService.getAllProduct());
        }catch (JsonProcessingException e){
            return "Json error" + e;
        }
    }
    @GetMapping("/{id}")
    public String getProductById(@PathVariable Long id){
        try {
            return objectMapper.writeValueAsString(productService.getProduct(id));
        }catch (JsonProcessingException e){
            return "Json error" + e;
        }
    }
    @PostMapping
    public String addProduct(@RequestBody String json){
        try {
            Product product = objectMapper.readValue(json, Product.class);
            productService.createProduct(product);
            return "Json accepted";
        } catch (JsonProcessingException e) {
            return "Json error " + e;
        }

    }
    @PatchMapping("/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody String json){
        try {
            Product product = objectMapper.readValue(json, Product.class);
            productService.updateProduct(id, product);
            return "success";
        }catch (JsonProcessingException e){
            return "json error";
        }
    }

    @DeleteMapping({"/{id}"})
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "success";
    }
}
