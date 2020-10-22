package com.example.surittec.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.surittec.models.User;
import com.example.surittec.models.dtos.UserDTO;
import com.example.surittec.services.PhoneService;
import com.example.surittec.services.UserService;
import com.example.surittec.services.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private PhoneService phoneService;

	@GetMapping
	private @ResponseBody ResponseEntity<?> findAllUsers() {
		List<User> users = userService.findAll();
		return ResponseEntity.ok().body(users);
	}

	@PostMapping
	public ResponseEntity<?> register(@Valid @RequestBody UserDTO userDto) {
		User user = userDto.userDtoToUser();

		userService.save(user); 
		user.getListPhone().stream().forEach(phone -> phoneService.save(phone));

		return ResponseEntity.ok().body(user.getListEmail());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		User user = userService.findById(id);
		
		return ResponseEntity.ok().body(user);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserDTO userDto)
			throws ObjectNotFoundException {
		User userUpdate = userDto.userDtoToUser();
		User user = userService.findById(id);

		user.setName(userUpdate.getName());
		user.setCpf(userUpdate.getCpf());
		user.setListEmail(userUpdate.getListEmail());

		user.getListPhone().stream().forEach(phone -> {
			phone.setUser(null);
			phoneService.delete(phone);
		});

		user.setListPhone(new ArrayList<>());

		userUpdate.getListPhone().stream().forEach(phone -> {
			user.addPhone(phone);
			phoneService.save(phone);
		});

		user.getAddress().setCep(userUpdate.getAddress().getCep());
		user.getAddress().setPlace(userUpdate.getAddress().getPlace());
		user.getAddress().setDistrict(userUpdate.getAddress().getDistrict());
		user.getAddress().setCity(userUpdate.getAddress().getCity());
		user.getAddress().setUf(userUpdate.getAddress().getUf());
		user.getAddress().setComplement(userUpdate.getAddress().getComplement());

		userService.save(user);

		return ResponseEntity.ok().body(user);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		User user = userService.findById(id);
		user.getListPhone().stream().forEach(phone -> {
			phone.setUser(null);
			phoneService.delete(phone);
		});
		userService.delete(user);
		return ResponseEntity.ok().body("ok");
	}

}
