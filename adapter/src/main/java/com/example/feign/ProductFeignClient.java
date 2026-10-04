package com.example.feign;

import com.example.ConfiguredProductDto;
import com.example.PageDto;
import com.example.ProductConfigurationCommand;
import com.example.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product")
@Component
public interface ProductFeignClient {
    @GetMapping("/product")
    PageDto<ProductDto> getProducts(@RequestParam("page") int page, @RequestParam("size") int size);

    @PostMapping("/product/to-cart")
    ConfiguredProductDto configuredProduct(@RequestBody ProductConfigurationCommand productConfigurationCommand);
}
