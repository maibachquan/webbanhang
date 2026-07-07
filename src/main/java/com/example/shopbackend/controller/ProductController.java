package com.example.shopbackend.controller; // Lưu ý: giữ nguyên dòng package của đại ca nếu nó khác tên nhé

import com.example.shopbackend.model.Product;
import com.example.shopbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // 1. LẤY DANH SÁCH MÓN ĂN
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 2. THÊM MÓN ĂN MỚI
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // 3. XÓA MÓN ĂN THEO ID
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productRepository.deleteById(id);
    }
}