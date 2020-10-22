package com.example.surittec.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.surittec.models.User;


public interface UserRepository extends CrudRepository<User, Long> {

}
