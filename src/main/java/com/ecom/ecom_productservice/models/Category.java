package com.ecom.ecom_productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BaseModel{
    private String categoryName;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true) //just mapping many column table's attribute 'category'
    private List<Product> products;
}
