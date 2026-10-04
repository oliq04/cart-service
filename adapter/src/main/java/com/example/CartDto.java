package com.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class CartDto {
    private Long id;
    private List<ConfiguredProductDto> configuredProductList;
}
