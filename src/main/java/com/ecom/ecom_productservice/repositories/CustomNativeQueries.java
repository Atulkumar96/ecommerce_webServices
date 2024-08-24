package com.ecom.ecom_productservice.repositories;

public interface CustomNativeQueries {

    String findAllProductsByCategoryName = "select p.uuid, p.description, p.imageurl, p.price, p.title, p.category_uuid from products p " +
            "join categories c on p.category_uuid = c.uuid where category_name = :categoryName";
}
