package intellistart.task.Intellistarttask.controller;

import intellistart.task.Intellistarttask.domain.Person;
import intellistart.task.Intellistarttask.service.PersonService;
import intellistart.task.Intellistarttask.service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class PersonController {

    PersonService service;
    PurchaseService purchaseService;

    public PersonController(PersonService service, PurchaseService purchaseService) {
        this.service = service;
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        List<Person> result = service.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person entity) {
        Person result = service.create(entity);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        service.delete(id);
        purchaseService.deleteByPersonId(id);
        return HttpStatus.OK;
    }


}
