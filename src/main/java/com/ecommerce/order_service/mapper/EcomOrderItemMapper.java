package com.ecommerce.order_service.mapper;

import com.ecommerce.order_service.dto.EcomOrderItemDto;
import com.ecommerce.order_service.entity.EcomOrderItem;

public class EcomOrderItemMapper {

    public static EcomOrderItemDto mapToEcomOrderItemDto(EcomOrderItem item) {
        if (item == null) return null;

        EcomOrderItemDto dto = new EcomOrderItemDto();
        dto.setProductVariantId(item.getProductVariantId());
        dto.setQuantity(item.getQuantity());
        dto.setPrice(item.getPrice());
        return dto;
    }

    public static EcomOrderItem mapToEcomOrderItem(EcomOrderItemDto dto) {
        if (dto == null) return null;

        EcomOrderItem item = new EcomOrderItem();
        item.setProductVariantId(dto.getProductVariantId());
        item.setQuantity(dto.getQuantity());
        item.setPrice(dto.getPrice());
        return item;
    }
}
