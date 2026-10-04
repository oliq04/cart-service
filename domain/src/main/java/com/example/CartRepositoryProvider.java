package com.example;

import java.util.Optional;

public interface CartRepositoryProvider {
    Optional<Cart> findById(Long id);
    Cart save(Cart cart);
    boolean existsById(Long id);
}
