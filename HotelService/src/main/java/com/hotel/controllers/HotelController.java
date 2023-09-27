package com.hotel.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entities.Hotel;
import com.hotel.services.HotelService;



@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
//	create
	
	@PostMapping("/")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){

		Hotel h = this.hotelService.create(hotel);
		return new ResponseEntity<Hotel>(h,HttpStatus.CREATED);
	}
	
//	get single
	
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
		return new ResponseEntity<Hotel>(this.hotelService.get(hotelId),HttpStatus.CREATED);
	}
	
//	get all
	@GetMapping("/")
	public ResponseEntity<List<Hotel>> getHotels(){
		return new ResponseEntity<List<Hotel>>(this.hotelService.getAll(),HttpStatus.CREATED);
	}
}
