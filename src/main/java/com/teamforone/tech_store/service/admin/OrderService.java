package com.teamforone.tech_store.service.admin;

import com.teamforone.tech_store.model.Orders;

import java.util.List;

public interface OrderService {
    List<Orders> getAllOrders();
    Orders getOrderById(Long id);
    Orders updateOrderStatus(Long id, String status);
    void deleteOrder(Long id);
}

