import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RequiredArgsConstructor
public class CartService {

    private final CartRepositoryProvider cartRepository;
    private final ProductFeignClientProvider productFeignClient;

    public Cart createCart() {
        Cart cart = new Cart(null, new ArrayList<>());
        return cartRepository.save(cart);
    }

    public Cart addToCart(Long id, ProductConfigurationCommand productConfigurationCommand) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cart doesnt exists"));
        Product configuredProduct = productFeignClient.getConfiguredProduct(productConfigurationCommand);
        cart.getProductList().add(configuredProduct);
        cartRepository.save(cart);
        return cart;
    }

    public Cart showCart(Long id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Car doesnt exists"));
    }

}
