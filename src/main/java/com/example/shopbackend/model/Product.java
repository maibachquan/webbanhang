package com.example.shopbackend.model; // (Lưu ý: Tên package này của đại ca có thể khác, cứ để nguyên mặc định của máy)

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(columnDefinition = "varchar(50) default 'active'")
    private String status;

    // --- Các hàm Getter và Setter ---
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getPrice() { return price; }
    public void setPrice(Integer price) { this.price = price; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}