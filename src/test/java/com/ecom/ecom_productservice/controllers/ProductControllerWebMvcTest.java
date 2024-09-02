package com.ecom.ecom_productservice.controllers;

import com.ecom.ecom_productservice.dtos.GenericProductDto;
import com.ecom.ecom_productservice.models.Product;
import com.ecom.ecom_productservice.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//only initializes beans of and related to ProductController- No unnecessary beans initialization
@WebMvcTest(controllers = ProductController.class)

public class ProductControllerWebMvcTest {
    @Autowired
    private MockMvc mockMvc; //mocks HTTP requests, for API client Functional Testing

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper; //Jackson ObjectMapper to serialize Java objects into JSON and deserialize JSON string into Java objects

    @Test
    void getAllProductsReturnsEmptyListWhenNoProducts() throws Exception {
        when(productService.getAllProducts()).thenReturn(new ArrayList<>()); //mocked - productSercvice returns empty list - hardcoded

        mockMvc.perform(get("/products"))
                .andExpect(status().is(404))
                .andExpect(content().string("[]"))
                .andExpect(header().string("Content-Type", "application/json"));
    }

    @Test
    void getAllProductsReturnsListOfProducts() throws Exception {
        ArrayList<GenericProductDto> products = new ArrayList<>();
        products.add(new GenericProductDto());
        products.add(new GenericProductDto());
        products.add(new GenericProductDto());

        when(productService.getAllProducts()).thenReturn(products);

        mockMvc.perform(get("/products"))
                .andExpect(status().is(200))
                .andExpect(content().string(objectMapper.writeValueAsString(products)))
                .andExpect(header().string("Content-Type", "application/json"));

    }
}
