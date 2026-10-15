package com.example.mapper;

import com.example.Cart;
import com.example.CartDto;
import com.example.CartItem;
import com.example.ProductDto;
import com.example.entity.CartEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface CartMapper {

    Cart toPojo(CartEntity cart);
    CartDto toDto(Cart cart);
    CartEntity toEntity(Cart cart);
    CartItem toCartItem(ProductDto product);
}
