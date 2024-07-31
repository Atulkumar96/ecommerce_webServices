package com.ecom.ecom_productservice.services;

import com.ecom.ecom_productservice.dtos.GenericProductDto;
import com.ecom.ecom_productservice.models.Product;
import com.ecom.ecom_productservice.thirdPartyClients.FakeStoreProductDto;
import com.ecom.ecom_productservice.thirdPartyClients.FakeStoreProductServiceClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceStoreAPIImpl implements ProductService{

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;


    public ProductServiceStoreAPIImpl(FakeStoreProductServiceClient fakeStoreProductServiceClient){
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }


    @Override
    public List<GenericProductDto> getAllProducts() {
        List<FakeStoreProductDto> listofFakestoreProducts = fakeStoreProductServiceClient.getAllProducts();
        List<GenericProductDto> listofgenericProductDtos = new ArrayList<>();

        for(FakeStoreProductDto fakeStoreProductDtoItem : listofFakestoreProducts){
            listofgenericProductDtos.add(putFakeStoreDtoItemsToGenericDtoItems(fakeStoreProductDtoItem));
        }

        return listofgenericProductDtos;
    }

    public static GenericProductDto putFakeStoreDtoItemsToGenericDtoItems(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto product = new GenericProductDto();

        product.setProductId(fakeStoreProductDto.getProductId());
        product.setProductName(fakeStoreProductDto.getTitle());
        product.setCategory(fakeStoreProductDto.getCategory());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageURL(fakeStoreProductDto.getImageURL());

        return product;
    }
}
