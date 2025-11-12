package com.teamforone.tech_store.service.admin.impl;

import com.teamforone.tech_store.model.Orders;
import com.teamforone.tech_store.repository.admin.crud.OrderRepository;
import com.teamforone.tech_store.service.admin.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Orders getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public Orders updateOrderStatus(Long id, String status) {
        Orders order = getOrderById(id);
        if (order == null) {
            throw new IllegalArgumentException("Order not found with id: " + id);
        }

        try {
            Orders.OrderStatus statusEnum = Orders.OrderStatus.valueOf(status.toUpperCase());
            order.setStatus(statusEnum);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid order status: " + status);
        }

        return orderRepository.save(order);
    }


    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}

