package com.rating.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.entities.Rating;
import com.rating.repositories.RatingRepository;
import com.rating.services.RatingService;


@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Rating getRatingById(String ratingId) {
		// TODO Auto-generated method stub
		return this.ratingRepository.findByRatingId(ratingId);
	}

	@Override
	public List<Rating> getRatingsByUserId(String userId) {
		// TODO Auto-generated method stub
		return this.ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingsByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return this.ratingRepository.findByHotelId(hotelId);
	}

	@Override
	public Rating saveRating(Rating rating) {
		// TODO Auto-generated method stub
		rating.setRatingId(UUID.randomUUID().toString());

		return this.ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		// TODO Auto-generated method stub
		return this.ratingRepository.findAll();
	}

}
