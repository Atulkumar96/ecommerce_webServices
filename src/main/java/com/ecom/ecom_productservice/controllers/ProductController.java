package com.ecom.ecom_productservice.controllers;

import com.ecom.ecom_productservice.dtos.GenericProductDto;
import com.ecom.ecom_productservice.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        List<GenericProductDto> productsDto = productService.getAllProducts();
        return productsDto;
    }

}
