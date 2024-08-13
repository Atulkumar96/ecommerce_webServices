package com.ecom.ecom_productservice.controllers;

import com.ecom.ecom_productservice.dtos.GenericProductDto;
import com.ecom.ecom_productservice.services.ProductService;
import com.ecom.ecom_productservice.thirdPartyClients.FakeStoreProductDto;
import com.ecom.ecom_productservice.thirdPartyClients.FakeStoreProductServiceClient;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") int id){
        return productService.getProductById(id);
    }

    @PostMapping
    public GenericProductDto addProduct(@RequestBody GenericProductDto productDto){
        return productService.addProduct(productDto);
    }

    @PatchMapping("{id}")
    public GenericProductDto updateProduct(@RequestBody GenericProductDto productDto
    , @PathVariable("id") int id){
        return productService.updateProduct(productDto, id);
    }

    @DeleteMapping("{id}")
    public GenericProductDto deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }

}
