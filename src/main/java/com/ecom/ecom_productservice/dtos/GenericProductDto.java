package com.ecom.ecom_productservice.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GenericProductDto { //To interact with 3rd party API we dtos instead of models
    private int productId;
    private String title;
    private double price;
    private String category;
    private String description;
    private String imageURL;
}
