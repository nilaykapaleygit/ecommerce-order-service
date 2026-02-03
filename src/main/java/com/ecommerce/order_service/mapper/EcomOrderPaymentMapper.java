package com.ecommerce.order_service.mapper;

import com.ecommerce.order_service.dto.EcomOrderPaymentDto;
import com.ecommerce.order_service.entity.EcomOrderPayments;

public class EcomOrderPaymentMapper {
    public static EcomOrderPaymentDto mapToEcomOrderPaymentDto(EcomOrderPayments payment) {
        if (payment == null) return null;

        EcomOrderPaymentDto dto = new EcomOrderPaymentDto();
        dto.setPaymentId(payment.getPaymentId());
        dto.setPaymentStatus(payment.getPaymentStatus());
        dto.setPaymentMethod(payment.getPaymentMethod());
        dto.setTransactionId(payment.getTransactionId());
        dto.setAmount(payment.getAmount());
        dto.setCreatedAt(payment.getCreatedAt());
        return dto;
    }

    public static EcomOrderPayments mapToEcomOrderPayment(EcomOrderPaymentDto dto) {
        if (dto == null) return null;

        EcomOrderPayments payment = new EcomOrderPayments();
        payment.setPaymentId(dto.getPaymentId());
        payment.setPaymentStatus(dto.getPaymentStatus());
        payment.setPaymentMethod(dto.getPaymentMethod());
        payment.setTransactionId(dto.getTransactionId());
        payment.setAmount(dto.getAmount());
        payment.setCreatedAt(dto.getCreatedAt());
        return payment;
    }
}
