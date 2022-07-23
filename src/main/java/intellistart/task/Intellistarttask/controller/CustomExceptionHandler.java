package intellistart.task.Intellistarttask.controller;

import intellistart.task.Intellistarttask.exception.NotEnoughMoneyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> exception(NoSuchElementException exception) {
        return new ResponseEntity<>("No such id in base. " + exception.getMessage() , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<Object> noMoneyException(NotEnoughMoneyException exception) {
        return new ResponseEntity<>("Not enough money. " + exception.getMessage() , HttpStatus.EXPECTATION_FAILED);
    }



}
