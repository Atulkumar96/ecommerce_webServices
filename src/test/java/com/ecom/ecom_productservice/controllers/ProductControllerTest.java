package com.ecom.ecom_productservice.controllers;

import com.ecom.ecom_productservice.controllers.ProductController;
import com.ecom.ecom_productservice.dtos.GenericProductDto;
import com.ecom.ecom_productservice.exceptions.NotFoundException;
import com.ecom.ecom_productservice.services.ProductService;
import com.ecom.ecom_productservice.services.ProductServiceThirdPartyStoreAPIImpl;
import com.ecom.ecom_productservice.thirdPartyClients.FakeStoreProductServiceClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {
    @Autowired
    private ProductController productController;
    @MockBean
    private ProductService productService;

    @Test
    void testShouldReturnTitleAtulWithProductId1() throws NotFoundException {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setTitle("Atul");

        /*1. mocked the dependency - to test the productController.getProductById() method in Isolation
        productService is @MockBean object here
        productService.getProductById(1) is mocked/hardcoded to return the above created genericProductDto
        productService.getProductById(2) is will return null as productService is mocked -  so it will not return the real Product from Db
        */
        when(productService.getProductById(1)).thenReturn(genericProductDto);

        //2. Called to method to be UNIT TESTED in isolation
        GenericProductDto genericProductDto1 = productController.getProductById(1);

        //3. Finally Assert - Check the expected behavior
        assertEquals("Atul", genericProductDto1.getTitle());

        //productService is mocked -  so it will not return the real Product from Db, instead simply return null
        //assertNull(genericProductDto1);
    }

//    @Test
//    void testNullWhenProductWithIdDoesntExists() throws NotFoundException {
//        //using the @MockBean dependency- mocking/hardcoding the dependency using when().thenReturn();
//        when(productService.getProductById(1)).thenReturn(null);
//
//        GenericProductDto genericProductDto = productController.getProductById(101);
//
//        assertNull(genericProductDto);
//    }

//    @Test
//    void testOnePlusOneEqualsTrue() throws NotFoundException {
//        //System.out.println("Yes True");
//        assertFalse(3 == 1+1, "1 + 1 should be 3");
//
//    }
//
//    @Test
//    void testAdditionWorking(){
//        assert 1 + 1 == 2;
//        assert -1 + 0 == -1;
//        //assert -1 + -1 == 2;
//        assertEquals(-2, -1 + -1,"-1 + -1 should be equal to 2");
//    }
}
