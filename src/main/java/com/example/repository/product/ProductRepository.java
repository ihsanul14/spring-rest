package com.example.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.product.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}