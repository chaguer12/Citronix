package Citronix.controller;

import Citronix.exception.ErrorMessage;
import Citronix.exception.ValidationException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorMessage> handleValidationException(ValidationException validationExcep){
        ErrorMessage errMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), "oops...!");
        return new ResponseEntity<>(errMessage,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleGenralException(MethodArgumentNotValidException excep){
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(),"We're sorry a mistake from our behalf");
        return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleGenralException(EntityNotFoundException excep){
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(),"Record not found: " + excep.getMessage());
        return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
    }
}
