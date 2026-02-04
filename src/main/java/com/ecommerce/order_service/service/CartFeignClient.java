package com.ecommerce.order_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.order_service.dto.EcomCartDto;

@FeignClient(name="cart-service")
public interface CartFeignClient {

    @GetMapping("/cart/getCartByUser/{userId}")
    public EcomCartDto getCartByUser(@PathVariable Long userId);
    
}
