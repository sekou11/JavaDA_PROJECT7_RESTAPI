package com.nnk.springboot.repositories;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.domain.User;

@SpringBootTest
class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;

	@Test
	void userTest() {

		User user = new User("username", "Azerty@1", "fullname");
		// Save
		userRepository.save(user);
		Assert.assertNotNull(user.getId());
		Assert.assertTrue(user.getUsername().equals("username"));
		;

		// Update
		Integer id = user.getId();
		userRepository.findById(id);
		user.setUsername("UserName Update");
		// userRepository.updateUser(id, user);
		Assert.assertTrue(user.getUsername().equals("UserName Update"));

		// Find
		List<User> listResult = userRepository.findAll();
		Assert.assertTrue(listResult.size() > 0);
         //Delete
		Integer id2 = user.getId();
		userRepository.delete(user);
		Optional<User> userList = userRepository.findById(id2);
		Assert.assertFalse(userList.isPresent());
	}

}
