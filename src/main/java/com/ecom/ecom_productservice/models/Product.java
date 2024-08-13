package com.ecom.ecom_productservice.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Entity(name = "productsTable")
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModel{
    //private Long id;
    private String title;
    private String description;
    private double price;
    private String imageURL;
    private String categoryName;
}
