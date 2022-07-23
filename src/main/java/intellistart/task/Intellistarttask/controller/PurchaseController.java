package intellistart.task.Intellistarttask.controller;

import intellistart.task.Intellistarttask.domain.Person;
import intellistart.task.Intellistarttask.domain.Product;
import intellistart.task.Intellistarttask.domain.Purchase;
import intellistart.task.Intellistarttask.service.PersonService;
import intellistart.task.Intellistarttask.service.ProductService;
import intellistart.task.Intellistarttask.service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    PurchaseService service;
    PersonService personService;
    ProductService productService;

    public PurchaseController(PurchaseService service, PersonService personService, ProductService productService) {
        this.service = service;
        this.personService = personService;
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Purchase>> findAll() {
        List<Purchase> result = service.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Purchase> create(@RequestBody Purchase entity) {
        personService.withdrawMoney(entity.getPersonId(), productService.findById(entity.getProductId()).getPrice());
        Purchase result = service.create(entity);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/bought_product/{product_id}")
    public ResponseEntity<List<Person>> personsBoughtProduct(@PathVariable("product_id") Long productId){
        List<Purchase> purchases = service.findAllByProductId(productId);
        List<Person> result = new ArrayList<>();
        for (Purchase purchase : purchases) {
            Person currentPerson = personService.findById(purchase.getPersonId());
            if (!result.contains(currentPerson)) {
                result.add(currentPerson);
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/person_products/{person_id}")
    public ResponseEntity<List<Product>> personProducts(@PathVariable("person_id") Long personId) {
        List<Purchase> purchases = service.findAllByPersonId(personId);
        List<Product> result = new ArrayList<>();
        for (Purchase purchase : purchases) {
            result.add(productService.findById(purchase.getProductId()));
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
