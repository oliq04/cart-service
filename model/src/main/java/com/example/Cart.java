package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Cart {
    private Long id;
    private List<CartItem> cartItems;
    private BigDecimal total;

    public Cart addToCart(Product product) {
        this.cartItems.add(new CartItem(null,1L, product));
        this.total = this.total.add(product.getPrice().getTaxIncludedAmount());
        return this;
    }
}
