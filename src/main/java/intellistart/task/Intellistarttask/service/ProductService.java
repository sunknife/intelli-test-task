package intellistart.task.Intellistarttask.service;

import intellistart.task.Intellistarttask.domain.Product;
import intellistart.task.Intellistarttask.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    protected ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product create(Product entity) {
        return repository.save(entity);
    }

    public Product findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
