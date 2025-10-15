package com.example.User.Service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

}