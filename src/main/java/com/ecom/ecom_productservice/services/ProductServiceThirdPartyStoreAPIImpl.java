package com.ecom.ecom_productservice.services;

import com.ecom.ecom_productservice.dtos.GenericProductDto;
import com.ecom.ecom_productservice.exceptions.NotFoundException;
import com.ecom.ecom_productservice.thirdPartyClients.FakeStoreProductDto;
import com.ecom.ecom_productservice.thirdPartyClients.FakeStoreProductServiceClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Primary
@Service
public class ProductServiceThirdPartyStoreAPIImpl implements ProductService{

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;


    public ProductServiceThirdPartyStoreAPIImpl(FakeStoreProductServiceClient fakeStoreProductServiceClient){
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

        product.setProductId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setCategory(fakeStoreProductDto.getCategory());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageURL(fakeStoreProductDto.getImageURL());

        return product;
    }

    @Override
    public GenericProductDto getProductById(int id) throws NotFoundException{
        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductServiceClient.getProductById(id);

        if(fakeStoreProductDto == null) {
            throw new NotFoundException("Product with id = "+id+" doesn't exists");
            //return null;
        }

        return putFakeStoreDtoItemsToGenericDtoItems(fakeStoreProductDto);
    }

    @Override
    public GenericProductDto addProduct(GenericProductDto product) {
        return putFakeStoreDtoItemsToGenericDtoItems(fakeStoreProductServiceClient.addProduct(product));
    }

    @Override
    public GenericProductDto updateProduct(GenericProductDto product, int id) {
        return putFakeStoreDtoItemsToGenericDtoItems(fakeStoreProductServiceClient.updateProduct(product, id));
    }

    @Override
    public GenericProductDto deleteProduct(int id){
        return putFakeStoreDtoItemsToGenericDtoItems(fakeStoreProductServiceClient.deleteProduct(id));
    }
}
