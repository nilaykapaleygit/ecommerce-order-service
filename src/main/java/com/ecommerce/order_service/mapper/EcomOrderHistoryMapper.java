package com.ecommerce.order_service.mapper;

import com.ecommerce.order_service.dto.EcomOrderHistoryDto;
import com.ecommerce.order_service.entity.EcomOrderHistory;

public class EcomOrderHistoryMapper {
	   public static EcomOrderHistoryDto mapToEcomOrderHistoryDto(EcomOrderHistory history) {
	        if (history == null) return null;

	        EcomOrderHistoryDto dto = new EcomOrderHistoryDto();
	        dto.setStatus(history.getStatus());
	        dto.setRemarks(history.getRemarks());
	        dto.setChangedAt(history.getChangedAt());
	        return dto;
	    }

	    public static EcomOrderHistory mapToEcomOrderHistory(EcomOrderHistoryDto dto) {
	        if (dto == null) return null;

	        EcomOrderHistory history = new EcomOrderHistory();
	        history.setStatus(dto.getStatus());
	        history.setRemarks(dto.getRemarks());
	        history.setChangedAt(dto.getChangedAt());
	        return history;
	    }
}
