import org.mapstruct.SubclassMapping;

public interface ProductMapper {

    Product toProduct(ConfiguredProductDto configuredProductDto);
}
