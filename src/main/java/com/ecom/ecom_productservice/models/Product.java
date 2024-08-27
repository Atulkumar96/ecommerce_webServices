package com.ecom.ecom_productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType; //CascadeType is an enum
//import org.hibernate.annotations.*;

//@Entity
@Entity(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product extends BaseModel{
    //private Long id;
    private String title;
    //@Column(name = "desc")
    private String description;
    private double price;
    private String imageURL;
    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    private Category category;
}

//ToString() prints the the Product attributes/properties
//@Override
    //public String toString() {
    //    return String.format(
    //            "Product[id=%d, title='%s', description='%s']",
    //            id, title, description);
    //}


//Default Protected Constructor - only for the sake of JPA,
//You do not use it directly, so it is designated as protected
    //protected Customer() {}