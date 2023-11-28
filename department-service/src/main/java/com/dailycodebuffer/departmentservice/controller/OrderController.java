package com.dailycodebuffer.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dailycodebuffer.departmentservice.model.Order;
import com.dailycodebuffer.departmentservice.service.OrderService;

@RestController
@RequestMapping("/department")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        if (order.getCustomerName() == null || order.getCustomerName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer name is required");
        }
        if (order.getProduct() == null || order.getProduct().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product is required");
        }
        // Add more validation logic as needed

        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.ok(createdOrder);
    }
    // other endpoints to handle HTTP requests
}
