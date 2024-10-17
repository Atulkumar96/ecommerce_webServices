package com.ecom.ecom_productservice.controllers;

import com.ecom.ecom_productservice.dtos.GenericProductDto;
import com.ecom.ecom_productservice.models.Product;
import com.ecom.ecom_productservice.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    @Test
    void addProductToCreateANewProduct() throws Exception {
        GenericProductDto productToAdd = new GenericProductDto();
        productToAdd.setTitle("Rahul's Keyboard");
        productToAdd.setDescription("Rahul's Keyboard");
        productToAdd.setPrice(15.0);
        productToAdd.setImageURL("");
        productToAdd.setCategory("Computers");

        GenericProductDto addedProduct = new GenericProductDto();
        addedProduct.setProductId(101);
        addedProduct.setTitle("Rahul's Keyboard");
        addedProduct.setDescription("Rahul's Keyboard");
        addedProduct.setPrice(15.0);
        addedProduct.setImageURL("");
        addedProduct.setCategory("Computers");

        when(productService.addProduct(any())).thenReturn(addedProduct); //mocked dependency

        mockMvc.perform(post("/products")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(productToAdd)))
                .andExpect(status().isCreated())
                .andExpect(content().string(objectMapper.writeValueAsString(addedProduct)))
                .andExpect(header().string("Content-Type", "application/json"));

    }
}

//1. Test Cases must be written for Good Cases (expected), Bad Cases (not expected), Edge Cases

// I.
//2. To test JSON string details, Controller-API is returning
//we can use "assertj and hamcrest" matcher library

//.andExpect(jsonPath("$.product.name", is("Iphone")))
//.andExpect(jsonPath("$.length()", is(101)));

//jsonPath: provided by assertj library, is: matcher is provided by hamcrest library

// II.
//3. Till now we have tested the behavior but to test the implementation
// of "argument passed through productController method(sameParam) -> productService method(sameParam) is same or not"
// we can use @Captor
    //@Captor
    //private ArgumentCaptor<Long> idCaptor;

// Long id = 101L;
// productController.getProductById(id)

//verify(productService).getProductById(idCaptor.capture());
//assertEquals(id, idCaptor.getValue());
