package com.example.surittec.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.surittec.models.User;
import com.example.surittec.repositories.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;
	
	public User findByCpfAndPassword(String cpf, String password) {
		User user = userRepository.findByCpfAndPassword(cpf, password);
		return user;
	}
}
