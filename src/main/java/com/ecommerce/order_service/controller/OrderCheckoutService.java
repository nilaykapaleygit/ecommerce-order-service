package com.ecommerce.order_service.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.order_service.dto.EcomCartDto;
import com.ecommerce.order_service.dto.EcomCartItemDto;
import com.ecommerce.order_service.dto.EcomOrderDto;
import com.ecommerce.order_service.entity.EcomOrderItem;
import com.ecommerce.order_service.entity.EcomOrders;
import com.ecommerce.order_service.mapper.EcomOrderMapper;
import com.ecommerce.order_service.repo.EcomOrderRepo;
import com.ecommerce.order_service.service.CartFeignClient;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderCheckoutService {
	   
	    private final CartFeignClient cartFeignClient;
	    //private final InventoryFeignClient inventoryFeignClient;
	    //private final PaymentFeignClient paymentFeignClient;
	    private final EcomOrderRepo ecomOrderRepo;
	    //private final EcomOrderHistoryRepository historyRepository;

	    public OrderCheckoutService(CartFeignClient cartFeignClient, EcomOrderRepo ecomOrderRepo) {
	        this.cartFeignClient = cartFeignClient;
	        //this.inventoryFeignClient = inventoryFeignClient;
	        //this.paymentFeignClient = paymentFeignClient;
	        this.ecomOrderRepo = ecomOrderRepo;
	        //this.historyRepository = historyRepository;
	    }

		public EcomOrderDto checkout(EcomOrderDto ecomOrderDto, Long cartId) {

			EcomCartDto cart = cartFeignClient.getCartByUser(ecomOrderDto.getUserId());

			if (cart == null || cart.getCartItems().isEmpty()) {
				throw new RuntimeException("Cart is empty or invalid");
			}

			Double totalAmount = 0.0;

			for (EcomCartItemDto item : cart.getCartItems()) {
				Double itemTotal = item.getPriceAtAddTime() * item.getQuantity();
				totalAmount = totalAmount + itemTotal;
			}
			
			EcomOrders order = new EcomOrders();
			order.setUserId(ecomOrderDto.getUserId());
			order.setOrderStatus("CREATED");
			order.setTotalAmount(totalAmount);
			order.setCurrency("INR");
			order.setCreatedAt(LocalDateTime.now());
			
			List<EcomOrderItem> orderItems = new ArrayList<>();

			for (EcomCartItemDto cartItem : cart.getCartItems()) {

			    EcomOrderItem item = new EcomOrderItem();
			    item.setOrder(order);
			    item.setProductVariantId(cartItem.getProductVariantId());
			    item.setQuantity(cartItem.getQuantity());
			    item.setPrice(cartItem.getPriceAtAddTime());
			    item.setCreatedAt(LocalDateTime.now());

			    orderItems.add(item);
			}

			order.setOrderItems(orderItems);

			order = ecomOrderRepo.save(order);
			
			return EcomOrderMapper.mapToEcomOrderDto(order);
		}    

}
