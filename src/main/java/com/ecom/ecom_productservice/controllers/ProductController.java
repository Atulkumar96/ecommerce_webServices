package com.ecom.ecom_productservice.controllers;

import com.ecom.ecom_productservice.dtos.ExceptionDto;
import com.ecom.ecom_productservice.dtos.GenericProductDto;
import com.ecom.ecom_productservice.exceptions.NotFoundException;
import com.ecom.ecom_productservice.repositories.ProductRepository;
import com.ecom.ecom_productservice.services.ProductService;
import com.ecom.ecom_productservice.thirdPartyClients.FakeStoreProductDto;
import com.ecom.ecom_productservice.thirdPartyClients.FakeStoreProductServiceClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        List<GenericProductDto> productsDto = productService.getAllProducts();
        return productsDto;
    }

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") int id) throws NotFoundException {
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
    public ResponseEntity<GenericProductDto> deleteProduct(@PathVariable int id){
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);

        //Ecom service does not return a body
        //ThirdParty Store service returns the deleted object in the body
        //Check @Primary is being used in which service
    }

    //If any endpoint mapped method's service throws a NotFoundException then below Exception Handler
    //gets executed
    //Exception Handler for NotFoundException class
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException notFoundException){
        return new ResponseEntity<>(new ExceptionDto(HttpStatus.NOT_FOUND,
                notFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }

}
