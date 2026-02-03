package com.ecommerce.order_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.order_service.dto.EcomOrderDto;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	private final OrderCheckoutService orderCheckoutService;

    public OrderController(OrderCheckoutService orderCheckoutService) {
        this.orderCheckoutService = orderCheckoutService;
    }
    
    @PostMapping("/checkout/{cartId}")
    public ResponseEntity<EcomOrderDto> checkout(
            @RequestBody EcomOrderDto requestDto, @PathVariable Long cartId) {

        EcomOrderDto orderDto = orderCheckoutService.checkout(requestDto,cartId);

        return ResponseEntity.ok(orderDto);
    }

}
