package com.nnk.springboot.service.Impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.service.RatingService;
@Service
@Transactional
public class RatingServiceImpl implements RatingService {
	@Autowired
	private RatingRepository ratingRepository;  
	private static final Logger LOGGER = LogManager.getLogger(RatingServiceImpl .class);
	@Override
	public List<Rating> findAll() {
		LOGGER.debug("All a Curve List");
		return ratingRepository.findAll();
	}

	@Override
	public void save(Rating rating ) {
		LOGGER.debug("Save a Rating"+rating);
		ratingRepository.save(rating);
		
	}

	@Override
	public Optional<Rating> findbyId(Integer id) {
		LOGGER.debug("Find a Rating By id" +id);
		return ratingRepository.findById(id);
	}

	@Override
	public void delete(Rating rating) {
		LOGGER.debug("Delete a rating" +rating);
		ratingRepository.delete(rating);		
	}

	@Override
	public Rating updateRating(Integer id, Rating rating) {
		LOGGER.debug("Update  a Rating By id" + id);
		rating.setId(id);;
		ratingRepository.save(rating);
		return rating;
		
	}

}