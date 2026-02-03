package com.ecommerce.order_service.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
public class EcomOrderItemDto {
    private Long productVariantId;
    private Integer quantity;
    private Double price;
}
