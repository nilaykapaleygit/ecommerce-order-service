package com.ecommerce.order_service.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ECOM_ORDERS")
@Data
public class EcomOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "order_status", nullable = false, length = 30)
    private String orderStatus;

    @Column(name = "total_amount", nullable = false, precision = 12, scale = 2)
    private Double totalAmount;

    @Column(name = "currency", length = 10)
    private String currency;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /* Relationships */

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EcomOrderItem> orderItems;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<EcomOrderPayments> payments;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<EcomOrderHistory> orderHistory;
}
