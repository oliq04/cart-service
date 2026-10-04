package com.example.mapper;

import com.example.ConfiguredProductDto;
import com.example.Product;
import com.example.entity.ConfiguredProductEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProduct(ConfiguredProductDto configuredProductDto);
    @Mapping(target = "id", ignore = true)
    ConfiguredProductEntity toConfiguredEntity(Product product);

    @AfterMapping
    default void linkAccessories(@MappingTarget ConfiguredProductEntity product) {
        if (product.getAccessories() != null) {
            product.getAccessories().forEach(accessory -> accessory.setProductId(product));
        }
    }
}
