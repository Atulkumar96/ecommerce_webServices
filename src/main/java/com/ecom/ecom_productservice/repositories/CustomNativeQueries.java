package com.ecom.ecom_productservice.repositories;

public interface CustomNativeQueries {

    String findAllProductsByCategoryName = "select p.id, p.description, p.imageurl, p.price, p.title, p.category_id from products p " +
            "join categories c on p.category_id = c.id where category_name = :categoryName";
}
