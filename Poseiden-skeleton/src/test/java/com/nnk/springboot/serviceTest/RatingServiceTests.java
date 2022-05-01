package com.nnk.springboot.ServiceTest;

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
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.service.RatingService;


@SpringBootTest

public class RatingServiceTests {
	@Autowired
	private RatingService service;
	@MockBean
	private RatingRepository repository;

	
	@Test
    @DisplayName("Test save rating")
    void testSave() {
        // Setup our mock repository
       
		
		Rating rating = new Rating("Moodys Rating", "Sand PRating", "Fitch Rating", 10);
        doReturn(rating).when(repository).save(any());

        // Execute the service call
        Rating returnedRating = service.save(rating);

        // Assert the response
        Assertions.assertNotNull(returnedRating, "The saved rating should not be null");
        Assertions.assertEquals("Moodys Rating", returnedRating.getMoodysRating());
    }
	
	@Test
    @DisplayName("Test findById Success")
    void testFindById() {
        // Setup our mock repository
		Rating rating = new Rating("Moodys Rating", "Sand PRating", "Fitch Rating", 10);
        doReturn(Optional.of(rating)).when(repository).findById(6);

        // Execute the service call
        Optional<Rating> returnedRating = service.findbyId(6);

        // Assert the response
        Assertions.assertTrue(returnedRating.isPresent(), "Rating was not found");
        Assertions.assertSame(returnedRating.get(), rating, "The BidList returned was not the same as the mock");
    }
	
	@Test
    @DisplayName("Test findById Not Found")
    void testFindByIdNotFound() {
        // Setup our mock repository
        doReturn(Optional.empty()).when(repository).findById(6);

        // Execute the service call
        Optional<Rating> returnedRating = service.findbyId(6);

        // Assert the response
        Assertions.assertFalse(returnedRating .isPresent(), "Rating should not be found");
    }
	 
	@Test
    @DisplayName("Test findAll")
    void testFindAll() {
        // Setup our mock repository
		Rating rating1 = new Rating("Moodys Rating", "Sand PRating", "Fitch Rating", 10);
		Rating rating2 = new Rating("Moodys Rating2", "Sand PRating2", "Fitch Rating2", 10);
        doReturn(Arrays.asList(rating1, rating2)).when(repository).findAll();

        // Execute the service call
        java.util.List<Rating> ratings = service.findAll();

        // Assert the response
        Assertions.assertEquals(2, ratings.size(), "findAll should return 2 rating");
    }
	
	@Test
    @DisplayName("Test delete Rating Success")
    void testDelete() {
        // Setup our mock repository
		Rating r = new Rating();
		service.delete(r);
		service.delete(r);
		
		verify(repository ,times(2)).delete(r);;
}
}
