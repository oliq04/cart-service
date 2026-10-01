
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CartRepositoryImpl implements CartRepositoryProvider {
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    @Override
    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id)
                .map(cartMapper::toPojo);
    }

    @Override
    public Cart save(Cart cart) {
        CartEntity cartEntity = cartMapper.toEntity(cart);
        CartEntity savedCart = cartRepository.save(cartEntity);
        return cartMapper.toPojo(savedCart);
    }
}
