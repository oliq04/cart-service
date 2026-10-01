import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductFeignClientImpl implements ProductFeignClientProvider {

    private final ProductFeignClient productFeignClient;
    private final ProductMapper productMapper;

    @Override
    public Product getConfiguredProduct(ProductConfigurationCommand productConfigurationCommand) {
        ConfiguredProductDto configuredProductDto = productFeignClient.configuredProduct(productConfigurationCommand);
        return productMapper.toProduct(configuredProductDto);
    }
}
