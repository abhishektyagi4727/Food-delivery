package com.fooddelivery.repository;

import com.fooddelivery.entity.Product;
import com.fooddelivery.entity.ProductStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByStatus(ProductStatus status);
    List<Product> findByCategoryIdAndStatus(Long categoryId, ProductStatus status);
}