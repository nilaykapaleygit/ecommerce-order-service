package com.ecommerce.order_service.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class EcomCartDto {
    private Long cartId;
    private Long userId;
    private String status; // ACTIVE, CHECKED_OUT
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<EcomCartItemDto> cartItems;
}
