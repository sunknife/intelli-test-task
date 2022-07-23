package intellistart.task.Intellistarttask.repository;

import intellistart.task.Intellistarttask.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.file.LinkOption;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
