package com.bridgelabz.springfirst.exception;


import com.bridgelabz.springfirst.utility.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public final ResponseEntity<Response> userException(UserException e) {

        Response status=new Response(400,e.getMessage());
        return new ResponseEntity<Response>(status,HttpStatus.OK);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return errors;
    }


//    @ExceptionHandler(UserNotFoundException.class)
//    public final ResponseEntity<Response> bookException(UserNotFoundException e) {
//
//        Response status=new Response(400,e.getMessage());
//        return new ResponseEntity<Response>(status,HttpStatus.OK);
//    }
}
