package intellistart.task.Intellistarttask.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "purchase")
@Data
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "PersonId is mandatory")
    private Long personId;
    @NotNull(message = "ProductId is mandatory")
    private Long productId;
}
