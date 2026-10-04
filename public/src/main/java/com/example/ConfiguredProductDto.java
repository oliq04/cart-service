package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ConfiguredProductDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String type;
    private Long quantity;
    private String battery;
    private String color;
    private List<AccessoryDto> accessories;
    private String processor;
    private String ram;
}
