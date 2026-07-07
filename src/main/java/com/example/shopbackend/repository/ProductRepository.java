package com.example.shopbackend.repository; // (Đuôi package tùy máy đại ca)

import com.example.shopbackend.model.Product; // Import file Product ở trên vào
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Không cần gõ gì thêm, Spring Boot đã tự code sẵn lệnh SELECT, INSERT cho đại ca rồi
}