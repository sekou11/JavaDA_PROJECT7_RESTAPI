//package com.nnk.springboot.serviceTest;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.nnk.springboot.domain.User;
//import com.nnk.springboot.repositories.UserRepository;
//import com.nnk.springboot.service.UserService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserServiceTest {
//	@Autowired
//	private UserRepository  userRepository;
//	@Autowired
//	private UserService userService;
//
//	@WithMockUser(value = "test")
//	
//	@Test
//	public void UserServiceTest() {
//		User user = new User( "username",  "fullname");
//
//		// Save
//		userService.save(user);
//		Assert.assertNotNull(user.getId());
//		Assert.assertTrue(user.getUsername().equals("username"));
//
//		// Update
//		Integer id = user.getId();
//		userService.findbyId(id);
//		user.setUsername("UserName Update");
//		userService.updateUser(id, user);
//		Assert.assertTrue(user.getUsername().equals("UserName Update"));
//
//		// Find
//		List<User> listResult = userService.findAll();
//		Assert.assertTrue(listResult.size() > 0);
//
//		// Delete
//
//		
//		  
//		
//		Integer id2 = user.getId();
//		userService.delete(user);
//		Optional<User> userList = userRepository.findById(id2);
//		Assert.assertFalse(userList.isPresent());
//
//	}
//}
