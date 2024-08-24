package com.ecom.ecom_productservice.repositories;

import com.ecom.ecom_productservice.models.Category;
import com.ecom.ecom_productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    //JPA queries in Repository
    List<Product> findByTitle(String title);

    @Query(value = CustomNativeQueries.findAllProductsByCategoryName,
    nativeQuery = true)
    List<Product> findAllByCategory_Category_name(String categoryName);
}
