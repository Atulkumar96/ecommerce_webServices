package com.ecom.ecom_productservice.services;

import com.ecom.ecom_productservice.dtos.GenericProductDto;
import com.ecom.ecom_productservice.models.Product;
import java.util.List;

public interface ProductService {
    List<GenericProductDto> getAllProducts();

    GenericProductDto getProductById(int id);

    GenericProductDto addProduct(GenericProductDto product);
}
