package com.social.network.icapture.exception;


import com.amazonaws.AmazonServiceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.validation.ConstraintViolationException;

/**
 * allows the class to be global interceptor for all exceptions thrown by @RequestMapping controllers
 */
@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

    /**
     * this handler will handle all custom runtime exceptions
     */
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> handleAllCustomExceptions(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
        return new ResponseEntity<>(
                String.format("Exception thrown due to validation failure: %s", ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(
                String.format("Exception thrown due to validation failure: %s", ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AmazonServiceException.class)
    public ResponseEntity<Object> handleAmazonServiceException(AmazonServiceException ex) {
        return new ResponseEntity<>(
                String.format("AmazonServiceException thrown: %s", ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
