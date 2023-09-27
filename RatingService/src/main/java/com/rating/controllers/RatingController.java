package com.rating.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.entities.Rating;
import com.rating.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	
	@Autowired 
	private RatingService ratingService;
	
	
	@PostMapping("/")
	public ResponseEntity<Rating> saveRating(@RequestBody Rating rating){
		Rating r  = this.ratingService.saveRating(rating);
		
		return new ResponseEntity<Rating>(r,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Rating>> getAllRatings(){
		List<Rating> ratings = this.ratingService.getAllRatings();
		return new ResponseEntity<List<Rating>>(ratings,HttpStatus.OK);
	}
	
	@GetMapping("/byUser/{userId}")
	public ResponseEntity<List<Rating>> getByUserId(@PathVariable String userId){
		List<Rating> ratings = this.ratingService.getRatingsByUserId(userId);
		return new ResponseEntity<List<Rating>>(ratings, HttpStatus.OK);
	}
	
	@GetMapping("/byHotel/{hotelId}")
	public ResponseEntity<List<Rating>> getByHotelId(@PathVariable String hotelId){
		List<Rating> ratings = this.ratingService.getRatingsByHotelId(hotelId);
		return new ResponseEntity<List<Rating>>(ratings, HttpStatus.OK);
	}
}
