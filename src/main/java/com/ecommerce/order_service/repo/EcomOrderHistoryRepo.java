package com.ecommerce.order_service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.order_service.entity.EcomOrderHistory;


public interface EcomOrderHistoryRepo extends JpaRepository<EcomOrderHistory, Long> {
    List<EcomOrderHistory> findByOrderOrderIdOrderByChangedAtAsc(Long orderId);
}
