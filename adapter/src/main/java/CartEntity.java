import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class CartEntity {
    @Id
    private Long id;
    @ManyToMany()
    private List<ConfiguredProductEntity> productList;

}
