package com.example;

import java.util.List;
import java.util.Map;

public interface ProductFeignClientProvider {

    Product getConfiguredProduct(ProductConfigurationCommand productConfigurationCommand);

    List<Product> getConfiguredProducts(Map<Long, List<Long>> productsMap);
}
