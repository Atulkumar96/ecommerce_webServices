package com.ecom.ecom_productservice.thirdPartyClients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductServiceClient {

    @Value("https://fakestoreapi.com")
    private String fakeStoreAPIUrl;

    @Value("/products")
    private String fakeStoreProductsApiPath;

    private String productRequestBaseUrl;
    private RestTemplate restTemplate;

    public FakeStoreProductServiceClient(RestTemplate restTemplate, @Value("https://fakestoreapi.com") String fakeStoreAPIUrl, @Value("/products") String fakeStoreProductsApiPath) {
        this.restTemplate = restTemplate;
        this.productRequestBaseUrl = fakeStoreAPIUrl + fakeStoreProductsApiPath;
    }

    public List<FakeStoreProductDto> getAllProducts(){
         ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(productRequestBaseUrl, FakeStoreProductDto[].class);
         return List.of(response.getBody());
    }
    
}
