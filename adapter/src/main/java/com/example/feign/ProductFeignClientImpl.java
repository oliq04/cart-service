package com.example.feign;

import com.example.*;
import com.example.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Component
@Slf4j
public class ProductFeignClientImpl implements ProductFeignClientProvider {

    private final ProductFeignClient productFeignClient;
    private final ProductMapper productMapper;

    @Override
    public Product getConfiguredProduct(ProductConfigurationCommand productConfigurationCommand) {
        ProductDto configuredProductDto = productFeignClient.configuredProduct(productConfigurationCommand);
        return productMapper.toProduct(configuredProductDto);
    }

    @Override
    public List<Product> getConfiguredProducts(Map<Long, List<Long>> productsMap) {
       List<ProductDto> productDtoList = productFeignClient.getConfiguredProducts(productsMap);
       return productDtoList.stream().map(productMapper::toProduct)
               .toList();
    }
}
