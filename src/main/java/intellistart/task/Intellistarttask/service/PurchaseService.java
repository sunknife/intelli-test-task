package intellistart.task.Intellistarttask.service;

import intellistart.task.Intellistarttask.domain.Purchase;
import intellistart.task.Intellistarttask.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    protected PurchaseRepository repository;

    public PurchaseService(PurchaseRepository repository) {
        this.repository = repository;
    }

    public Purchase create(Purchase purchase) {
        return repository.save(purchase);
    }

    public List<Purchase> findAllByPersonId(Long personId) {
        return repository.findByPersonId(personId);
    }

    public List<Purchase> findAllByProductId(Long productId) {
        return repository.findByProductId(productId);
    }

    public void deleteByPersonId(Long personId) {
        repository.deleteByPersonId(personId);
    }

    public void deleteByProductId(Long productId){
        repository.deleteByProductId(productId);
    }

    public List<Purchase> findAll() {
        return repository.findAll();
    }

}
