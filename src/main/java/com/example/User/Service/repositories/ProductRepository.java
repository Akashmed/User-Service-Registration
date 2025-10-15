package com.example.User.Service.repositories;

import com.example.User.Service.dtos.ProductSummary;
import com.example.User.Service.entities.Category;
import com.example.User.Service.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
//    derived query method
    List<Product> findByPriceBetweenOrderByName(BigDecimal min, BigDecimal max);

//    using query annotation
    @Procedure("findProductsByPrice")
    List<Product> findProducts(BigDecimal min, BigDecimal max);

    @Query("select count(*) from Product p where p.price between :min and :max ")
    Long countProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

//    for update operation always use 'Modifying' annotation to tell hibernate
    @Modifying
    @Query("update Product p set p.price = :newPrice where p.category.id = :categoryID")
    void updatePriceByCategory(BigDecimal newPrice, BigDecimal categoryID);

    List<ProductSummary> findProductByCategory(Category category);
}