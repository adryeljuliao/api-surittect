package com.example.surittec.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.surittec.models.User;


public interface UserRepository extends CrudRepository<User, Long> {

	User findByCpfAndPassword(String cpf, String password);
	
	User findByCpf(String cpf);
	
	List<User> findByUserType(Integer userType);
}
