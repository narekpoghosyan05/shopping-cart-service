package com.example.shopping_cart.service;

import com.example.shopping_cart.kafka.CartEventProducer;
import com.example.shopping_cart.model.Cart;
import com.example.shopping_cart.model.Item;
import com.example.shopping_cart.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final CartEventProducer producer;

    public CartService(CartRepository cartRepository, CartEventProducer producer) {
        this.cartRepository = cartRepository;
        this.producer = producer;
    }

    public Cart createCart() {
        return cartRepository.save(new Cart());
    }

    public Cart addItem(Long cartId, Item item) {
        Cart cart = cartRepository.findById(cartId).orElseThrow();

        cart.getItems().add(item);

        Cart saved = cartRepository.save(cart);

        producer.sendItemAddedEvent(
                "Item" + item.getName() + " added to cart " + cartId
        );

        return saved;
    }

    public List<Item> getItems(Long cartId) {
        return cartRepository.findById(cartId)
                .orElseThrow()
                .getItems();
    }
}
