package com.example.feign;

import com.example.*;
import com.example.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ProductFeignClientImpl implements ProductFeignClientProvider {

    private final ProductFeignClient productFeignClient;
    private final ProductMapper productMapper;

    @Override
    public Product getConfiguredProduct(ProductConfigurationCommand productConfigurationCommand) {
        ConfiguredProductDto configuredProductDto = productFeignClient.configuredProduct(productConfigurationCommand);
        return productMapper.toProduct(configuredProductDto);
    }
}
