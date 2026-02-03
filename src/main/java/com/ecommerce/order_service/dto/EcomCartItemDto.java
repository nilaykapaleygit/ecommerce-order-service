package com.ecommerce.order_service.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EcomCartItemDto {
    private Long cartItemId;
    private EcomCartDto cart;
    private Long productId;
    private Long productVariantId;
    private Integer quantity;
    private Double priceAtAddTime;
    private LocalDateTime createdAt;
}
