package com.example.router.product;

import java.util.List;
import com.example.model.product.Product;

public class ResponseProduct {
    private Integer code;
    private String message;
    private List<Product> data;

    public Integer getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }
    public List<Product> getData(){
        return data;
    }
    public void setCode(Integer code){
        this.code = code;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public void setData(List<Product> data){
        this.data = data;
    }
}