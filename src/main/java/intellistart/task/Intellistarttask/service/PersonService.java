package intellistart.task.Intellistarttask.service;

import intellistart.task.Intellistarttask.domain.Person;
import intellistart.task.Intellistarttask.exception.NotEnoughMoneyException;
import intellistart.task.Intellistarttask.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PersonService {

    protected PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person create(Person entity) {
        System.out.println("Repository works");
        return repository.save(entity);
    }

    public Person findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void withdrawMoney(Long personId,BigDecimal amount) throws NotEnoughMoneyException {
        Person person = findById(personId);
        if (person.getMoneyAmount().compareTo(amount) >= 0) {
            person.setMoneyAmount(person.getMoneyAmount().subtract(amount));
            repository.save(person);
        } else {
            throw new NotEnoughMoneyException(person.getFirstName() + " " + person.getLastName() + " has not enough money");
        }


    }
}
