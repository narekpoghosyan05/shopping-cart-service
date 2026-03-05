package com.example.shopping_cart.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private LocalDateTime createdAt;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cart_id")
    private List<Item> items = new ArrayList<>();

    public Cart() {
        this.createdAt = LocalDateTime.now();
    }

    // Optional constructor with userId and items
    public Cart(Long userId, List<Item> items) {
        this.userId = userId;
        this.items = items != null ? items : new ArrayList<>();
        this.createdAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items != null ? items : new ArrayList<>();
    }

    // Helper methods
    public void addItem(Item item) {
        if (item != null) {
            this.items.add(item);
        }
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    // Calculate total price of the cart
    public double calculateTotalPrice() {
        return items.stream()
                .mapToDouble(item -> item.getQuantity() * item.getPrice())
                .sum();
    }
}