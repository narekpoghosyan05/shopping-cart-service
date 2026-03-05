package com.example.shopping_cart.mapper;

import com.example.shopping_cart.dto.CartResponse;
import com.example.shopping_cart.dto.ItemRequest;
import com.example.shopping_cart.model.Cart;
import com.example.shopping_cart.model.Item;

import java.util.List;
import java.util.stream.Collectors;

public class CartMapper {

    // Entity → DTO
    public static CartResponse toResponse(Cart cart) {
        CartResponse response = new CartResponse();
        response.setCartId(cart.getId());
        response.setUserId(cart.getUserId());

        // Map List<Item> → List<ItemRequest>
        List<ItemRequest> itemRequests = cart.getItems().stream()
                .map(item -> new ItemRequest(item.getProductId(), item.getQuantity(), item.getPrice()))
                .collect(Collectors.toList());

        response.setItems(itemRequests);

        // Calculate total price
        double total = itemRequests.stream()
                .mapToDouble(item -> item.getQuantity() * item.getPrice())
                .sum();

        response.setTotalPrice(total);

        response.setCreatedAt(cart.getCreatedAt());

        return response;
    }
}
