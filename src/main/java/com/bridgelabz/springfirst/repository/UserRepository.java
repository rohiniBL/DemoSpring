package com.bridgelabz.springfirst.repository;

import com.bridgelabz.springfirst.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByFname(String fname);

    User findByEmail(String email);
}
