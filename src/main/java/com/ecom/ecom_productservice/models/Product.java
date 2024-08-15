package com.ecom.ecom_productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Entity(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product extends BaseModel{
    //private Long id;
    private String title;
    private String description;
    private double price;
    private String imageURL;
    @ManyToOne
    private Category category;
}
