package com.example.router.product;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.usecase.product.ProductUsecase;
import com.example.model.response.ResponseProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;


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
        }catch(Exception err){
            response.setCode(500);
            response.setMessage(err.toString());
        }
        
        return new ResponseEntity<>(gson.toJson(response), headers, HttpStatus.OK);
    }   
}
