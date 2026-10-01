import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cart")
@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final CartMapper cartMapper;

    @GetMapping
    public CartDto showCart(Long id) {
        return cartMapper.toDto(cartService.showCart(id));
    }

    @PostMapping
    public CartDto addToCart(Long id, ProductConfigurationCommand product) {
        return cartMapper.toDto(cartService.addToCart(id, product));
    }
}
