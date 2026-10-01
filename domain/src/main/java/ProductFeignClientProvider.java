public interface ProductFeignClientProvider {

    Product getConfiguredProduct(ProductConfigurationCommand productConfigurationCommand);
}
