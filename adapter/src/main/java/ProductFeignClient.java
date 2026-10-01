import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product")
public interface ProductFeignClient {
    @GetMapping("/products")
    PageDto<ProductDto> getProducts(@RequestParam("page") int page, @RequestParam("size") int size);

    @PostMapping("/products/to-cart")
    ConfiguredProductDto configuredProduct(@RequestBody ProductConfigurationCommand productConfigurationCommand);
}
