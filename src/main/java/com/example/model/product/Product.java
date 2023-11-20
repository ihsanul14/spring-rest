package com.example.model.product;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "testing")
public class Product {
    @Id
    private Integer id;

    @Column(name = "nama")
    private String name;

    private Integer nomor;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;
    
    // Constructors, getters, and setters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getNomor() {
        return nomor;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return createdAt;
    }


    // Setter methods
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNomor(Integer nomor) {
        this.nomor = nomor;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = name;
    }
}