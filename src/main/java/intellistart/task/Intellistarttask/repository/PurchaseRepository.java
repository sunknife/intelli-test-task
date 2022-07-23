package intellistart.task.Intellistarttask.repository;

import intellistart.task.Intellistarttask.domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    public List<Purchase> findByPersonId(Long personId);

    public List<Purchase> findByProductId(Long productId);

    @Transactional
    public void deleteByPersonId(Long personId);

    @Transactional
    public void deleteByProductId(Long productId);
}
