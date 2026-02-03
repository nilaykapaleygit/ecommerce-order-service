package com.ecommerce.order_service.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class EcomOrderPayments {
	   	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "payment_id")
	    private Long paymentId;

	    @Column(name = "payment_status", nullable = false, length = 30)
	    private String paymentStatus;

	    @Column(name = "payment_method", length = 30)
	    private String paymentMethod;

	    @Column(name = "transaction_id", length = 100)
	    private String transactionId;

	    @Column(name = "amount", nullable = false, precision = 12, scale = 2)
	    private BigDecimal amount;

	    @Column(name = "created_at")
	    private LocalDateTime createdAt;

	    /* Relationship */

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "order_id", nullable = false)
	    private EcomOrders order;
}
