package com.example.shopping_cart.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CartController.class)
class CartControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    void shouldReturnCart() throws Exception {
//        mockMvc.perform(get("/cart/1"))
//                .andExpect(status().isOk());
//    }
}
