package com.example.mapper;

import com.example.Accessory;
import com.example.AccessoryDto;
import com.example.Cart;
import com.example.CartDto;
import com.example.entity.AccessoriesEntity;
import com.example.entity.CartEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface CartMapper {

    Cart toPojo(CartEntity cart);
    CartDto toDto(Cart cart);
    CartEntity toEntity(Cart cart);

    List<AccessoriesEntity> toEntity(List<Accessory> accessory);
    List<AccessoryDto> toDto(List<Accessory> accessories);
}
