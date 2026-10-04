package com.example;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

@RequiredArgsConstructor
public class CartService {

    private static final Logger log = LogManager.getLogger(CartService.class);
    private final CartRepositoryProvider cartRepository;
    private final ProductFeignClientProvider productFeignClient;

    public Cart createCart() {
        Cart cart = new Cart(null, new ArrayList<>());
        return cartRepository.save(cart);
    }

    public Cart addToCart(Long id, ProductConfigurationCommand productConfigurationCommand) {
        log.info("Adding to cart...");
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("com.example.Cart doesnt exists"));
        Product configuredProduct = productFeignClient.getConfiguredProduct(productConfigurationCommand);
        cart.getProductList().add(configuredProduct);
        cartRepository.save(cart);
        log.info("Product saved.");
        log.info("Returning cart {}", cart);
        return cart;
    }

    public Cart showCart(Long id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Car doesnt exists"));
    }

}
