package com.ecom.ecom_productservice.repositories;

import com.ecom.ecom_productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Optional<Category> findByCategoryName(String categoryName);
}
