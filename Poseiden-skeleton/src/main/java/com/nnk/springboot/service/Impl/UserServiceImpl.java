package com.nnk.springboot.service.Impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.service.BidListService;
import com.nnk.springboot.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;  
	private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl .class);

	@Override
	public List<User> findAll() {
		LOGGER.debug("All Users");
		return userRepository.findAll();
	}

	@Override
	public void save(User user) {
		LOGGER.debug("Save a User" +user);
		userRepository.save(user);
		
	}

	@Override
	public Optional<User> findbyId(Integer id) {
		LOGGER.debug("Find a User By Id" +id);
		return userRepository.findById(id);
	}

	@Override
	public void delete(User user) {
		LOGGER.debug("Delete a User" +user);
		userRepository.delete(user);		
	}

}