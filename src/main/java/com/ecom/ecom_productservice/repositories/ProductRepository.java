package com.ecom.ecom_productservice.repositories;

import com.ecom.ecom_productservice.models.Category;
import com.ecom.ecom_productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    //JPA queries in Repository
    List<Product> findByTitle(String title);

    //Native MySQL Query
    @Query(value = CustomNativeQueries.findAllProductsByCategoryName,
    nativeQuery = true)
    List<Product> findAllByCategory_Category_name(String categoryName);

    //HQL - Hibernate Query Language - allows compile time checking of syntax
    //preferred to avoid database portability hassles


    @Override
    Optional<Product> findById(Integer id);
}

//JpaRepository extends PagingAndSortingRepository which in turn extends CrudRepository
    //CrudRepository mainly provides CRUD functions.
    //PagingAndSortingRepository provides methods to do pagination and sorting records.
    //JpaRepository provides some JPA-related methods such as flushing the persistence context and deleting records in a batch.
//Because of the inheritance mentioned above,
// JpaRepository will have all the functions of CrudRepository and PagingAndSortingRepository