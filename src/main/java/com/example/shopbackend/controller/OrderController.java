package com.example.shopbackend.controller;

import com.example.shopbackend.model.Order;
import com.example.shopbackend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    // 1. KHÁCH ĐẶT HÀNG (Lưu xuống MySQL)
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    // 2. ADMIN LẤY TOÀN BỘ ĐƠN HÀNG (Hiện lên bảng điều khiển)
    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // 3. KHÁCH TRA CỨU ĐƠN HÀNG THEO MÃ
    @GetMapping("/{code}")
    public Order getOrderByCode(@PathVariable String code) {
        return orderRepository.findByOrderCode(code).orElse(null);
    }

    // 4. ADMIN CẬP NHẬT TRẠNG THÁI ĐƠN (Duyệt đơn / Hủy đơn)
    @PutMapping("/{id}/status")
    public Order updateOrderStatus(@PathVariable Integer id, @RequestParam String status) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setStatus(status);
            return orderRepository.save(order);
        }
        return null;
    }
}