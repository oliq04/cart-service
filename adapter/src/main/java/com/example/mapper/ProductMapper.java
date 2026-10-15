package com.example.mapper;

import com.example.*;
import com.example.entity.CartItemEntity;
import com.example.entity.ProductConfigurationIdEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProduct(ProductDto productDto);

    @Mapping(target = "productId", source = "product.id")
    CartItemEntity toCartItemEntity(CartItem cartItem);

    @Mapping(target = "productConfigurationId", source = "id")
    ProductConfigurationIdEntity toProductConfigurationIdEntity(ProductOption productOption);
}
