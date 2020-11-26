package com.bridgelabz.springfirst.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {


    @NotNull
    @Size(min=2, message="Name should have atleast 2 characters")
    private String fname;

    @NotNull
    @Size(min=2, message="Name should have atleast 2 characters")
    private String lname;

    private String email;

    public UserDto(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
