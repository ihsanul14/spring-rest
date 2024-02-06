package com.example.usecase.product;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.repository.product.ProductRepository;
import com.example.model.product.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductUsecase {
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> GetData() {
        return this.productRepository.findAll();
    }
    
    public void Create(Product data) {
        this.productRepository.save(data);
    }

    public void Update(Product data) {
        this.productRepository.save(data);
    }

    public void Delete(Product data) {
        this.productRepository.delete(data);
    }
}
