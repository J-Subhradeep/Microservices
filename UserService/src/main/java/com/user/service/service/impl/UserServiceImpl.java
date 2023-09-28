package com.user.service.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.user.service.entities.Rating;
import com.user.service.entities.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.repositories.UserRepository;
import com.user.service.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		user.setUserId(UUID.randomUUID().toString());
		return userRepository.save(user);
//		return null;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("NOT FOUND USER"));
		
		
		//getting service url from service name
		List<ServiceInstance> instances = this.discoveryClient.getInstances("RATING-SERVICE");
	    ServiceInstance instance = instances.get(0);
	    String url = instance.getUri().toString();
	    System.out.println(url);
	    
	    
	    // getting data
		Rating[] ratings = restTemplate.getForObject(url+"/ratings/byUser/"+userId, Rating[].class);
		System.out.println(ratings);
		user.setRatings(ratings);
		return user;
	}

}
