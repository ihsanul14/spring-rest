package com.example.router.product;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.*;
import com.example.usecase.product.ProductUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.model.product.Product;

import java.util.ArrayList;
import java.util.List;


class Request {
    private Integer id;

    private String nama;

    private Integer nomor;

    public Integer getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public Integer getNomor() {
        return nomor;
    }
}

@RestController
@RequestMapping("/api/data")
public class ProductRouter {
    Gson gson = new Gson();
    private final ProductUsecase productUsecase;

    @Autowired
    public ProductRouter(ProductUsecase productUsecase) {
        this.productUsecase = productUsecase;
    }

    @GetMapping
    public ResponseEntity<String> GetData() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseProduct response = new ResponseProduct();
        try{ 
            response.setCode(200);
            response.setMessage("Success");
            response.setData(productUsecase.GetData());
            return new ResponseEntity<>(gson.toJson(response), headers, HttpStatus.OK);
        }catch(Exception err){
            response.setCode(500);
            response.setMessage(err.toString());
            return new ResponseEntity<>(gson.toJson(response), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> GetDataById(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseProduct response = new ResponseProduct();
        try{
            List<Product> res = new ArrayList<>();
            response.setCode(200);
            response.setMessage("Success");
            productUsecase.GetDataById(id).ifPresent(res::add);
            response.setData(res); 
            return new ResponseEntity<>(gson.toJson(response), headers, HttpStatus.OK);
        }catch(Exception err){
            response.setCode(500);
            response.setMessage(err.toString());
            return new ResponseEntity<>(gson.toJson(response), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
    @PostMapping
    public ResponseEntity<String> Create(@RequestBody Request data) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseProduct response = new ResponseProduct();
        try{
            response.setCode(200);
            response.setMessage("Success");
            Product product = new Product();
            product.setName(data.getNama());
            product.setNomor(data.getNomor());
            productUsecase.Create(product);
            return new ResponseEntity<>(gson.toJson(response), headers, HttpStatus.OK);
        }catch(Exception err){
            response.setCode(500);
            response.setMessage(err.toString());
            return new ResponseEntity<>(gson.toJson(response), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> Update(@PathVariable Integer id, @RequestBody Request data) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseProduct response = new ResponseProduct();
        try{
            response.setCode(200);
            response.setMessage("Success");
            Product product = new Product();
            product.setId(id);
            product.setName(data.getNama());
            product.setNomor(data.getNomor());
            productUsecase.Create(product);
            return new ResponseEntity<>(gson.toJson(response), headers, HttpStatus.OK);
        }catch(Exception err){
            response.setCode(500);
            response.setMessage(err.toString());
            return new ResponseEntity<>(gson.toJson(response), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> Delete(@PathVariable Integer id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseProduct response = new ResponseProduct();
        try{
            response.setCode(200);
            response.setMessage("Success");
            Product product = new Product();
            product.setId(id);
            productUsecase.Delete(product);
            return new ResponseEntity<>(gson.toJson(response), headers, HttpStatus.OK);
        }catch(Exception err){
            response.setCode(500);
            response.setMessage(err.toString());
            return new ResponseEntity<>(gson.toJson(response), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
