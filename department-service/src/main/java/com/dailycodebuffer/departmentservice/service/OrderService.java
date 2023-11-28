package com.dailycodebuffer.departmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dailycodebuffer.departmentservice.model.Order;
import com.dailycodebuffer.departmentservice.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        order.setStatus("ACCEPTED");
        return orderRepository.save(order);
    }
    // other methods to handle business logic
}
