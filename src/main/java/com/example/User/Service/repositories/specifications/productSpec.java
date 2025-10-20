package com.example.User.Service.repositories.specifications;

import com.example.User.Service.entities.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class productSpec {
    public static Specification<Product> hasName(String name){
        return (Root<Product> root,CriteriaQuery<?> query, CriteriaBuilder cb ) -> cb.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<Product> hasPriceGreaterThanOrEqualTo(BigDecimal price){
        return (Root<Product> root,CriteriaQuery<?> query, CriteriaBuilder cb ) -> cb.greaterThanOrEqualTo(root.get("price"), price);

    }

    public static Specification<Product> hasPriceLessThanOrEqualTo(BigDecimal price){
        return (Root<Product> root,CriteriaQuery<?> query, CriteriaBuilder cb ) -> cb.lessThanOrEqualTo(root.get("price"), price);

    }
}
