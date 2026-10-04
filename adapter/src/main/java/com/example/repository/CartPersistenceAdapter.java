package com.example.repository;

import com.example.Cart;
import com.example.CartRepositoryProvider;
import com.example.entity.CartEntity;
import com.example.entity.ConfiguredProductEntity;
import com.example.mapper.CartMapper;
import com.example.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CartPersistenceAdapter implements CartRepositoryProvider {
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final ProductMapper productMapper;

    @Override
    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id)
                .map(cartMapper::toPojo);
    }

    @Override
    public Cart save(Cart cart) {
        List<ConfiguredProductEntity> configuredProductEntities = cart.getProductList().stream()
                .map(productMapper::toConfiguredEntity)
                .toList();
        CartEntity cartEntity = cartMapper.toEntity(cart);
        cartEntity.setProductList(configuredProductEntities);
        CartEntity savedCart = cartRepository.save(cartEntity);
        return cartMapper.toPojo(savedCart);
    }

    @Override
    public boolean existsById(Long id) {
        return cartRepository.existsById(id);
    }
}
