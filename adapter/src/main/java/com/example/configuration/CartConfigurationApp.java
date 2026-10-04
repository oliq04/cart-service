package com.example.configuration;

import com.example.CartRepositoryProvider;
import com.example.CartService;
import com.example.ProductFeignClientProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CartConfigurationApp {

    @Bean
    public CartService cartService(CartRepositoryProvider cartRepositoryProvider, ProductFeignClientProvider productFeignClient) {
        return new CartService(cartRepositoryProvider, productFeignClient);
    }
}
