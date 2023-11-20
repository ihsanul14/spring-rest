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

// class ProductDao {
//     // private static final String INSERT_PRODUCT = "INSERT INTO testing (name, description, price) VALUES (?, ?, ?)";
//     // private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM testing";
//     // private static final String UPDATE_PRODUCT = "UPDATE testing SET name = ?, description = ?, price = ? WHERE id = ?";
//     // private static final String DELETE_PRODUCT = "DELETE FROM testing WHERE id = ?";

//     public List<Product> getAllProducts() {
//         List<Product> products = new ArrayList<>();
//         try (Connection connection = Database.getConnection();
//              Statement statement = connection.createStatement();
//              ResultSet resultSet = statement.executeQuery(SELECT_ALL_PRODUCTS)) {
//             while (resultSet.next()) {
//                 Integer id = resultSet.getInt("id");
//                 String name = resultSet.getString("nama");
//                 String description = resultSet.getString("nama");
//                 double price = resultSet.getDouble("nomor");
//                 Product product = new Product(id, name, description, price);
//                 products.add(product);
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//         return products;
//     }
// }