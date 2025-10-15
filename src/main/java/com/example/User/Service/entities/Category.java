package com.example.User.Service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST, orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude
    private Set<Product> products = new HashSet<>();

    public void addProducts(Product product){
        products.add(product);
        product.setCategory(this);
    }

}