package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class ConfiguredProduct {
    private Long id;
    private String name;
    private BigDecimal price;
    private String type;
    private Long quantity;
}
