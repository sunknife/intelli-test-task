package intellistart.task.Intellistarttask.domain;

import lombok.Data;

@Data
public class Purchase {
    private Long id;
    private Long userId;
    private Long productId;
}
