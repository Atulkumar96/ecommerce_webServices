package com.ecom.ecom_productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name = "categories")
public class Category extends BaseModel{
    private String category_name;
    @OneToMany(mappedBy = "category") //just mapping many column table attribute
    private List<Product> products;
}
