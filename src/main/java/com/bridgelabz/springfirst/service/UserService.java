package com.bridgelabz.springfirst.service;

import com.bridgelabz.springfirst.dto.UserDto;
import com.bridgelabz.springfirst.exception.UserException;
import com.bridgelabz.springfirst.model.User;
import com.bridgelabz.springfirst.repository.UserRepository;
import com.bridgelabz.springfirst.utility.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUser{

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Response add(UserDto userDto) {
        User userExist=userRepository.findByEmail(userDto.getEmail());
        if(userExist !=null ){
            throw new UserException(402,"Record Already Exit0");
        }
        User user = modelMapper.map(userDto, User.class);
        userRepository.save(user);
        Response response=new Response(200, "Added");
        return response;
    }

//    public Long getById(long id){
//        User user = userRepository.findById(id).orElseThrow(() -> new UserException(400, "ID not Found"));
//        return user.getId();
//    }

    public User getById(long id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserException(400, "ID not Found"));
        return user;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Response updateEmployees(long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserException(400, "ID not Found"));
        user.setFname(userDto.getFname());
        user.setEmail(userDto.getEmail());
        user.setLname(userDto.getLname());
        userRepository.save(user);
        Response response=new Response(200, "Update Record Sucessfully");
        return response;
    }

    @Override
    public Response deleteEmployee(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserException(400, "ID not Found"));
        userRepository.delete(user);
        Response response=new Response(200, "Deleted Record Sucessfully");
        return response;
    }
}
