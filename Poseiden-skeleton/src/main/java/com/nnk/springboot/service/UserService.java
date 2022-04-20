package com.nnk.springboot.service;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.domain.User;

public interface UserService {

	public List<User> findAll();

	public User save( User user );

	public Optional<User> findbyId(Integer id);

	public void delete(User User);
	public User updateUser(Integer id,User user);

}
