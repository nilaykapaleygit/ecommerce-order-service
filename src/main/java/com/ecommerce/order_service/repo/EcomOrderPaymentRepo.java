package com.ecommerce.order_service.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.order_service.entity.EcomOrderPayments;


public interface EcomOrderPaymentRepo extends JpaRepository<EcomOrderPayments, Long> {
    List<EcomOrderPayments> findByOrderOrderId(Long orderId);

    Optional<EcomOrderPayments> findByTransactionId(String transactionId);
}
