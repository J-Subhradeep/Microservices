package com.rating.entities;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ratings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(RatingID.class)
public class Rating {


	@Column(nullable = false, unique = true)
	private String ratingId;
	
	@Id
	private String userId;
	@Id
	private String hotelId;
	
	private int rating;
}
