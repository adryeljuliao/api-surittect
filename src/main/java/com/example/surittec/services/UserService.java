package com.example.surittec.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.surittec.models.User;
import com.example.surittec.repositories.UserRepository;

@Service
public class UserService {

	private static final Logger LOG = LoggerFactory.getLogger(User.class);

	@Autowired
	private UserRepository userRepository;

	public void save(User user) {
		userRepository.save(user);
		LOG.info("usuario salvo com sucesso");
	}

	public void delete(User user) {
		userRepository.delete(user);
		LOG.info("usuario removido com sucesso");
	}

	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElse(null);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

}
