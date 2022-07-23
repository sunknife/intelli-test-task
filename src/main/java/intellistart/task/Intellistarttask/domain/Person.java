package intellistart.task.Intellistarttask.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "person")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String firstName;
    @NotBlank(message = "Surname is mandatory")
    private String lastName;
    @NotNull(message = "Money Amount is mandatory")
    private BigDecimal moneyAmount;
}
