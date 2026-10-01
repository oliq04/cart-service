import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    Cart toPojo(CartEntity cart);
    CartDto toDto(Cart cart);
    CartEntity toEntity(Cart cart);
}
