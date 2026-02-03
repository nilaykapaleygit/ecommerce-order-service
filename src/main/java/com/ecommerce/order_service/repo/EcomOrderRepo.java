package com.ecommerce.order_service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.order_service.entity.EcomOrders;

public interface EcomOrderRepo extends JpaRepository<EcomOrders, Long>{
    List<EcomOrders> findByUserId(Long userId);

    List<EcomOrders> findByOrderStatus(String orderStatus);
}
