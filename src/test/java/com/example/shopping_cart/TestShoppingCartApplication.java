package com.example.shopping_cart;

import org.springframework.boot.SpringApplication;

public class TestShoppingCartApplication {

	public static void main(String[] args) {
		SpringApplication.from(ShoppingCartApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
