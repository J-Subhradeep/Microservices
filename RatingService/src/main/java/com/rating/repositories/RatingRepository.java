package com.rating.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rating.entities.Rating;
import com.rating.entities.RatingID;

public interface RatingRepository extends JpaRepository<Rating, RatingID> {
	Rating findByRatingId(String ratingId);
	List<Rating> findByUserId(String userId);
	List<Rating> findByHotelId(String hotelId);
}
