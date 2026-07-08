package com.example.shopbackend.repository;

import com.example.shopbackend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    // Tìm kiếm đơn hàng bằng mã đơn (phục vụ tính năng Tra cứu)
    Optional<Order> findByOrderCode(String orderCode);
}