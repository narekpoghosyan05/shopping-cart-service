package com.example.shopping_cart.dto;

public class ItemRequest {

    private Long productId;
    private String name;
    private Integer quantity;
    private Double price;

    // Default constructor
    public ItemRequest(Long productId, Integer quantity, Double price) {}

    // Full constructor
    public ItemRequest(Long productId, String name, Integer quantity, Double price) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity != null ? quantity : 1;
        this.price = price;
    }

    // Getters & Setters
    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity != null ? quantity : 1;
    }

    public Double getPrice() {
        return price;
    }
}
