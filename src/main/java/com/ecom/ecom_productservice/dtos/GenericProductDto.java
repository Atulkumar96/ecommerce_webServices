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
public class GenericProductDto {
    private int productId;
    private String productName;
    private double price;
    private String category;
    private String description;
    private String imageURL;
}
