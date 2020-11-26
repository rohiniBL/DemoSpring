package com.bridgelabz.springfirst.service;

import com.bridgelabz.springfirst.dto.UserDto;
import com.bridgelabz.springfirst.exception.UserException;
import com.bridgelabz.springfirst.utility.Response;

public interface IUser {

    public Response add(UserDto userDto);
    public Long getById(long id);
}
