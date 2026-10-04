package com.example;

public interface ProductFeignClientProvider {

    Product getConfiguredProduct(ProductConfigurationCommand productConfigurationCommand);
}
