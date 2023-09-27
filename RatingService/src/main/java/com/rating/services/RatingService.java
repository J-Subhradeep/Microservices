package com.rating.services;

import java.util.List;

import com.rating.entities.Rating;

public interface RatingService {
	Rating getRatingById(String ratingId);
	List<Rating> getRatingsByUserId(String userId);
	List<Rating> getRatingsByHotelId(String hotelId);
	Rating saveRating(Rating rating);
	List<Rating> getAllRatings();
	
}
