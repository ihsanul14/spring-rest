package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.repository.product.ProductRepository;
import com.example.model.product.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
public class Application {
    @Autowired
    private ProductRepository productRepository;
    
    public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
    }

    @GetMapping("/api/data")
    public List<Product> hello(String name) {
      return productRepository.findAll();
    }
}