package com.bridgelabz.springfirst.controller;

import com.bridgelabz.springfirst.dto.UserDto;
//import com.bridgelabz.springfirst.exception.MethodArgumentNotValidException;
import com.bridgelabz.springfirst.model.User;
import com.bridgelabz.springfirst.service.IUser;
import com.bridgelabz.springfirst.utility.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/hello")
public class DemoController {

    @Autowired
    IUser iUser;

    @RequestMapping(value ={"/demo"},method= RequestMethod.GET)
    public String hello(@RequestParam(value = "name") String name){
        return name;
    }

    @GetMapping
    public String hello1(@PathVariable(value = "name") String name){
        return name;
    }

    @GetMapping(value = "/getname/{name}")
    public String hello2(@PathVariable(value = "name") String name){
        return name;
    }


    @PostMapping
    public ResponseEntity<Response> addUser(@Valid @RequestBody UserDto userDto) {
        Response response=iUser.add(userDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @PutMapping(value = "/{name}")
    public String update(@PathVariable(value = "name") String name,@RequestParam(value = "lname") String lname){
        System.out.println("UserName"+name+"LastName"+lname);
        return name+" =="+lname;
    }

    @GetMapping(value = "/getData/{id}")
    public Long getByID(@PathVariable(value = "id") long id){
        return iUser.getById(id);
    }


}
