package com.example;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CartService {
    private final CartRepositoryProvider cartRepository;
    private final ProductFeignClientProvider productFeignClient;

    public Cart createCart() {
        Cart cart = new Cart(null, new ArrayList<>(), BigDecimal.ZERO);
        return cartRepository.save(cart);
    }

    public Cart addToCart(Long id, ProductConfigurationCommand productConfigurationCommand) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cart doesnt exists"));
        Product configuredProduct = productFeignClient.getConfiguredProduct(productConfigurationCommand);
        cart.addToCart(configuredProduct);
        cartRepository.save(cart);
        return showCart(id);
    }

    public Cart showCart(Long id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Car doesnt exists"));
        Map<Long, List<Long>> productWithOptions = cart.getCartItems().stream()
                .map(CartItem::getProduct)
                .collect(Collectors.toMap(
                        Product::getId,
                        product -> product.getOptions().stream()
                                .map(ProductOption::getId)
                                .toList()
                ));
        List<Product> products = productFeignClient.getConfiguredProducts(productWithOptions);

        Map<Long, Product> productsById = products.stream()
                .collect(Collectors.toMap(Product::getId, Function.identity()));

        cart.getCartItems().forEach(cartItem -> {
            Long itemId = cartItem.getProduct().getId();
            Product configured = productsById.get(itemId);
            if (configured == null) {
                throw new IllegalArgumentException("Product not found: " + itemId);
            }
            cartItem.setProduct(configured);
        });
        return cart;
    }
}
