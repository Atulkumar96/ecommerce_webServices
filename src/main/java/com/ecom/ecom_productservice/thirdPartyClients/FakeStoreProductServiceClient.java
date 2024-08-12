package com.ecom.ecom_productservice.thirdPartyClients;

import com.ecom.ecom_productservice.dtos.GenericProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductServiceClient {

    @Value("https://fakestoreapi.com")
    private String fakeStoreAPIUrl;

    @Value("/products")
    private String fakeStoreProductsApiPath;

    private String productRequestBaseUrl;
    private String specificProductRequestUrl;
    private RestTemplate restTemplate;

    public FakeStoreProductServiceClient(RestTemplate restTemplate, @Value("https://fakestoreapi.com") String fakeStoreAPIUrl, @Value("/products") String fakeStoreProductsApiPath) {
        this.restTemplate = restTemplate;
        this.productRequestBaseUrl = fakeStoreAPIUrl + fakeStoreProductsApiPath;
        this.specificProductRequestUrl = productRequestBaseUrl + "/{id}";
    }

    public List<FakeStoreProductDto> getAllProducts(){
         ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(productRequestBaseUrl, FakeStoreProductDto[].class);
         return List.of(response.getBody());
    }

    public FakeStoreProductDto getProductById(int productId){
        return restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDto.class, productId).getBody();
    }

    public FakeStoreProductDto addProduct(GenericProductDto productDto){
        return restTemplate.postForEntity(productRequestBaseUrl, productDto, FakeStoreProductDto.class).getBody();
//        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
//        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
//                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
//        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.execute(productRequestBaseUrl,
//                HttpMethod.POST,requestCallback,responseExtractor,productDto);
//        return responseEntity.getBody();
    }

    public FakeStoreProductDto updateProduct(GenericProductDto productDto, int id){
       //For PATCH method need DEPENDENCY - org.apache.httpcomponents.client5 in POM.XML
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        return restTemplate.exchange(specificProductRequestUrl,HttpMethod.PATCH,new HttpEntity<>(productDto),FakeStoreProductDto.class,id).getBody();
    }

}
