package com.example.testjava;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.product.Product;
import com.example.router.product.ResponseProduct;
import com.example.usecase.product.ProductUsecase;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
class TestRouter {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductUsecase productUsecase;

    @Test
    public void TestGetData() throws Exception {
        List<Product> products = Arrays.asList(
            new Product()
        );
        when(productUsecase.GetData()).thenReturn(products).thenThrow(new RuntimeException("error"));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/data")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/data")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    public void TestGetDataById() throws Exception {
        when(productUsecase.GetDataById(1L)).thenReturn(Optional.of(new Product())).thenThrow(new RuntimeException("error"));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/data/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/data/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    public void TestCreate() throws Exception {
        Product product = new Product();
        product.setId(1);
        product.setName("Test Product");
        product.setNomor(12345);
        String productJson = new ObjectMapper().writeValueAsString(product);

        doNothing().when(productUsecase).Create(product);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/data")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productJson))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void TestUpdate() throws Exception {
        Product product = new Product();
        product.setId(1);
        product.setName("Test Product");
        product.setNomor(12345);
        String productJson = new ObjectMapper().writeValueAsString(product);

        doNothing().when(productUsecase).Update(product);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/data/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productJson))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void TestDelete() throws Exception {
        doNothing().when(productUsecase).Delete(any(Product.class));
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/data/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
