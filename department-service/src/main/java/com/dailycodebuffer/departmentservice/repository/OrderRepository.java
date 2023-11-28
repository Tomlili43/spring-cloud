package com.dailycodebuffer.departmentservice.repository;

// OrderRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.departmentservice.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
