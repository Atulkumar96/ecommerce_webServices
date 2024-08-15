package com.ecom.ecom_productservice.repositories;


import com.ecom.ecom_productservice.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
