package com.example.shopping_cart.controller;

import com.example.shopping_cart.model.Cart;
import com.example.shopping_cart.model.Item;
import com.example.shopping_cart.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    @PostMapping
    public Cart createCart() {
        return service.createCart();
    }

    @PostMapping("/{cartId}/items")
    public Cart addItem(@PathVariable Long cartId, @RequestBody Item item) {
        return service.addItem(cartId, item);
    }

    @GetMapping("/{cartId}/items")
    public List<Item> getItems(@PathVariable Long cartId) {
        return service.getItems(cartId);
    }
}
