package com.bridgelabz.springfirst.service;

import com.bridgelabz.springfirst.dto.UserDto;
import com.bridgelabz.springfirst.model.User;
import com.bridgelabz.springfirst.utility.Response;

import java.util.List;

public interface IUser {

    public Response add(UserDto userDto);
    public User getById(long id);

    List<User> getAll();

    Response updateEmployees(long id, UserDto userDto);

    Response deleteEmployee(long id);
}
