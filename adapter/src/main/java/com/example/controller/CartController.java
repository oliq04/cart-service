package com.example.controller;

import com.example.Cart;
import com.example.CartDto;
import com.example.CartService;
import com.example.ProductConfigurationCommand;
import com.example.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cart")
@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final CartMapper cartMapper;

    @GetMapping
    public CartDto showCart(@RequestParam("id") Long id) {
        return cartMapper.toDto(cartService.showCart(id));
    }

    @PostMapping
    public CartDto addToCart(@RequestParam("id") Long id, @RequestBody ProductConfigurationCommand product) {
        return cartMapper.toDto(cartService.addToCart(id, product));
    }

    @PostMapping("/new")
    public CartDto createCart() {
        Cart cart =  cartService.createCart();
        return cartMapper.toDto(cart);
    }
}
