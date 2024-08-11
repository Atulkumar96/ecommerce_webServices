package com.ecom.ecom_productservice.thirdPartyClients;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreProductDto {
    private int id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String imageURL;
}

//output
//            {
//id:31,
//title:'...',
//price:'...',
//category:'...',
//description:'...',
//image:'...'
//        }
