import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ConfiguredProductEntity {
    @Id
    private Long id;
    private String name;
    private BigDecimal price;
    private String type;
    private Long quantity;
    private String battery;
    private String color;
    private List<String> accessories;
    private String processor;
    private String ram;

    @ManyToMany
    private CartEntity cartEntity;

}
