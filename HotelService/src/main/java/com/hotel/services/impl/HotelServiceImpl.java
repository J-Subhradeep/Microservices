package com.hotel.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;

import com.hotel.entities.Hotel;
import com.hotel.repositories.HotelRepository;
import com.hotel.services.HotelService;
import com.hotel.services.exceptions.ResourceNotFoundException;

@Service
public class HotelServiceImpl implements HotelService{

	
	@Autowired
	private HotelRepository hotelRepository;
	
	
	
	@Override
	public Hotel create(Hotel hotel) {
		// TODO Auto-generated method stub
		String id = UUID.randomUUID().toString();
		hotel.setId(id);
		return this.hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return this.hotelRepository.findAll();
	}

	@Override
	public Hotel get(String id) {
		// TODO Auto-generated method stub
		return this.hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel with given id not found"));
	}

}
