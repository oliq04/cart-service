package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
    private String type;
    private Long quantity;
    private String battery;
    private String color;
    private List<Accessory> accessories;
    private String processor;
    private String ram;
}
