package intellistart.task.Intellistarttask.controller;

import intellistart.task.Intellistarttask.domain.Person;
import intellistart.task.Intellistarttask.domain.Product;
import intellistart.task.Intellistarttask.service.ProductService;
import intellistart.task.Intellistarttask.service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService service;
    PurchaseService purchaseService;

    public ProductController(ProductService service, PurchaseService purchaseService) {
        this.service = service;
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> result = service.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product entity) {
        Product result = service.create(entity);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        service.delete(id);
        purchaseService.deleteByProductId(id);
        return HttpStatus.OK;
    }

}
