package com.ecommerce.order_service.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
public class EcomOrderPaymentDto {
    private Long paymentId;
    private String paymentStatus;
    private String paymentMethod;
    private String transactionId;
    private BigDecimal amount;
    private LocalDateTime createdAt;
}
