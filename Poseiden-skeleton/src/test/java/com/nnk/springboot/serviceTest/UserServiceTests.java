package com.nnk.springboot.serviceTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.service.UserService;


@SpringBootTest

public class UserServiceTests {
	@Autowired
	private UserService service;
	@MockBean
	private UserRepository repository;

	
	@Test
    @DisplayName("Test save users")
    void testSave() {
        // Setup our mock repository
       
		
		User user = new User("username", "Azerty@1", "fullname");
        doReturn(user).when(repository).save(any());

        // Execute the service call
        User returnedUser = service.save(user);

        // Assert the response
        Assertions.assertNotNull(returnedUser, "The saved user should not be null");
        Assertions.assertEquals("username", returnedUser.getUsername());
    }
	
	@Test
    @DisplayName("Test findById Success")
    void testFindById() {
        // Setup our mock repository
		User user = new User("username", "Azerty@1", "fullname");
        doReturn(Optional.of(user)).when(repository).findById(6);

        // Execute the service call
        Optional<User> returnedUser = service.findbyId(6);

        // Assert the response
        Assertions.assertTrue(returnedUser.isPresent(), "User was not found");
        Assertions.assertSame(returnedUser.get(), user, "The user returned was not the same as the mock");
    }
	
	@Test
    @DisplayName("Test findById Not Found")
    void testFindByIdNotFound() {
        // Setup our mock repository
        doReturn(Optional.empty()).when(repository).findById(6);

        // Execute the service call
        Optional<User> returnedUser = service.findbyId(6);

        // Assert the response
        Assertions.assertFalse(returnedUser .isPresent(), "User should not be found");
    }
	
	@Test
    @DisplayName("Test findAll")
    void testFindAll() {
        // Setup our mock repository
		User user1 = new User("username", "Azerty@1", "fullname");
		User user2 = new User("username2", "Azerty@12", "fullname2");
        doReturn(Arrays.asList(user1, user2)).when(repository).findAll();

        // Execute the service call
        java.util.List<User> users = service.findAll();

        // Assert the response
        Assertions.assertEquals(2, users.size(), "findAll should return 2 users");
    }
	
	@Test
    @DisplayName("Test delete User Success")
    void testDelete() {
        // Setup our mock repository
		User user = new User();
		service.delete(user);
		service.delete(user);
		
		verify(repository ,times(2)).delete(user);;
}
}
