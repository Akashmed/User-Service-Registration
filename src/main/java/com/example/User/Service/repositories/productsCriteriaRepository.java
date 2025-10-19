package com.example.User.Service.repositories;

import com.example.User.Service.entities.Product;

import java.math.BigDecimal;
import java.util.List;

public interface productsCriteriaRepository {
    List<Product> findProductsByCriteria(String name, BigDecimal minPrice, BigDecimal maxPrice);
}
