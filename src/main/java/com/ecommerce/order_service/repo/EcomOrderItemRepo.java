package com.ecommerce.order_service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.order_service.entity.EcomOrderItem;

public interface EcomOrderItemRepo extends JpaRepository<EcomOrderItem, Long>{
	   List<EcomOrderItem> findByOrderOrderId(Long orderId);
}
