package com.example.shopping_cart.service;

import com.example.shopping_cart.kafka.CartEventProducer;
import com.example.shopping_cart.model.Cart;
import com.example.shopping_cart.model.Item;
import com.example.shopping_cart.repository.CartRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {

    @Mock
    CartRepository repository;

    @Mock
    CartEventProducer producer;

    @InjectMocks
    CartService service;

    @Test
    void shouldAddItemToCart() {
        Cart cart = new Cart();
        cart.setId(1L);

        when(repository.findById(1L))
                .thenReturn(Optional.of(cart));

        service.addItem(1L, new Item("Phone", 1000.0));

        assertEquals(1, cart.getItems().size());
        verify(producer).sendItemAddedEvent(anyString());
    }
}
