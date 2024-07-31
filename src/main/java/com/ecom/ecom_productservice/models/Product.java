package com.ecom.ecom_productservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageURL;
    private String categoryName;
}
