package com.nnk.springboot.service;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.domain.Rating;

public interface RatingService {

	public List<Rating> findAll();

	public void save( Rating rating );

	public Optional<Rating> findbyId(Integer id);

	public void delete(Rating rating);

	public Rating updateRating(Integer id, Rating rating);

}
