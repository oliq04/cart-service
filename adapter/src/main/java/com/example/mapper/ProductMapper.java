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
    @Mapping(target = "productConfigurationIds", source = "product.options")
    CartItemEntity toCartItemEntity(CartItem cartItem);

    @Mapping(target = "product.id", source = "productId")
    @Mapping(target = "product.options", source = "productConfigurationIds")
    CartItem toCartItemEntity(CartItemEntity cartItem);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "productConfigurationId", source = "id")
    @Mapping(target = "cartItemEntity", ignore = true)
    ProductConfigurationIdEntity toProductConfigurationIdEntity(ProductOption productOption);

    @Mapping(target = "id", source = "productConfigurationId")
    ProductOption toProductOption(ProductConfigurationIdEntity productConfigurationId);
}
