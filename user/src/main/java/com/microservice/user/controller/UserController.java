package com.microservice.user.controller;

import com.microservice.user.repositories.*;
import com.microservice.user.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = userRepository.findById(id).get();
		return ResponseEntity.ok(obj);
	}

	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		User obj = userRepository.findByEmail(email);
		return ResponseEntity.ok(obj);
	}
}
