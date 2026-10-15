package com.example.feign;

import com.example.PageDto;
import com.example.ProductConfigurationCommand;
import com.example.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "product")
@Component
public interface ProductFeignClient {
    @GetMapping("/product")
    PageDto<ProductDto> getProducts(@RequestParam("page") int page, @RequestParam("size") int size);

    @PostMapping("/product/to-cart")
    ProductDto configuredProduct(@RequestBody ProductConfigurationCommand productConfigurationCommand);

    List<ProductDto> getConfiguredProducts(@RequestBody Map<Long, List<Long>> productsWithConfigs);
}
