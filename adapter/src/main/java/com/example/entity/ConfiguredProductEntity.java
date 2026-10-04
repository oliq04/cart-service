package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "configured_product")
public class ConfiguredProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private String type;
    private Long quantity;
    private String battery;
    private String color;

    @OneToMany(mappedBy = "productId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AccessoriesEntity> accessories;
    private String processor;
    private String ram;

    @ManyToMany(mappedBy = "productList")
    private List<CartEntity> cartEntity;

}
