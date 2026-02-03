package com.ecommerce.order_service.mapper;

import com.ecommerce.order_service.dto.EcomOrderDto;
import com.ecommerce.order_service.entity.EcomOrders;

public class EcomOrderMapper {
    public static EcomOrderDto mapToEcomOrderDto(EcomOrders order) {
        if (order == null) return null;

        EcomOrderDto dto = new EcomOrderDto();
        dto.setOrderId(order.getOrderId());
        dto.setUserId(order.getUserId());
        dto.setOrderStatus(order.getOrderStatus());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setCurrency(order.getCurrency());
        dto.setCreatedAt(order.getCreatedAt());

        if (order.getOrderItems() != null) {
            dto.setItems(
                order.getOrderItems()
                     .stream()
                     .map(EcomOrderItemMapper::mapToEcomOrderItemDto)
                     .toList()
            );
        }

        return dto;
    }

    public static EcomOrders mapToEcomOrder(EcomOrderDto dto) {
        if (dto == null) return null;

        EcomOrders order = new EcomOrders();
        order.setOrderId(dto.getOrderId());
        order.setUserId(dto.getUserId());
        order.setOrderStatus(dto.getOrderStatus());
        order.setTotalAmount(dto.getTotalAmount());
        order.setCurrency(dto.getCurrency());
        order.setCreatedAt(dto.getCreatedAt());

        if (dto.getItems() != null) {
            order.setOrderItems  (
                    dto.getItems()
                    .stream()
                    .map(EcomOrderItemMapper::mapToEcomOrderItem)
                    .toList()
             );
          
        }

        return order;
    }
}
