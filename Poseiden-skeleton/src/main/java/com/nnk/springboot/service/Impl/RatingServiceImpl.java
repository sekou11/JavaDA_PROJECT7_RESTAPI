package com.nnk.springboot.service.Impl;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<Rating> findAll() {
		// TODO Auto-generated method stub
		return ratingRepository.findAll();
	}

	@Override
	public void save(Rating rating ) {
		ratingRepository.save(rating);
		
	}

	@Override
	public Optional<Rating> findbyId(Integer id) {
		
		return ratingRepository.findById(id);
	}

	@Override
	public void delete(Rating rating) {
		ratingRepository.delete(rating);		
	}

}