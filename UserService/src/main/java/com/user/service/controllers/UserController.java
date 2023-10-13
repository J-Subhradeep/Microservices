package com.user.service.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.entities.User;
import com.user.service.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;



@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User u = userService.saveUser(user);
		return new ResponseEntity<User>(u,HttpStatus.CREATED);
	}
	
	@GetMapping("/{userId}")
	@CircuitBreaker(name = "ratingBreaker",fallbackMethod = "ratingFallback")
	public ResponseEntity<User> getSintleUser(@PathVariable String userId){
		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
	
	@GetMapping("/")
	
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser = userService.getAllUser();
		return new ResponseEntity<List<User>>(allUser,HttpStatus.OK);
	}
	
//	creating fall back method for circuit breaker
	public ResponseEntity<User> ratingFallback(String userId,Exception ex){
		System.out.println(ex.getMessage());
		List<User> list = new ArrayList<>();
		User u = new User();
		u.setName("No User");
		u.setEmail("No User");
		list.add(u);
		return new ResponseEntity<User> (u,HttpStatus.OK);
	}
}
