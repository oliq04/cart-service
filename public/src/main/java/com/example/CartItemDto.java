package com.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CartItemDto {
    private Long id;
    private Long quantity;
    private ProductDto product;
}
