package com.eugen.obiedkov.OrderService.service;

import com.eugen.obiedkov.OrderService.model.OrderRequest;
import com.eugen.obiedkov.OrderService.model.OrderResponse;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);

    OrderResponse getOrderDetails(Long orderId);
}

