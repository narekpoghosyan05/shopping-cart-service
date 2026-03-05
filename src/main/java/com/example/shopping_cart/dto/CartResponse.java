package com.example.shopping_cart.dto;

import java.util.List;

public class CartResponse {
    private Long cartId;
    private Long userId;
    private List<ItemRequest> items;
    private double totalPrice;

    // Getters and Setters
    public Long getCartId() {
        return cartId;
    }
    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public List<ItemRequest> getItems() {
        return items;
    }
    public void setItems(List<ItemRequest> items) {
        this.items = items;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
