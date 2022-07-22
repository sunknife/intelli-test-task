package intellistart.task.Intellistarttask.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private BigDecimal moneyAmount;
}
