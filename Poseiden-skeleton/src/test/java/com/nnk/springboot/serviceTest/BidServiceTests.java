package com.nnk.springboot.ServiceTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.service.BidListService;




@SpringBootTest

public class BidServiceTests {
	@Autowired
	private BidListService service;
	@MockBean
	private BidListRepository repository;

	
	@Test
    @DisplayName("Test save bidList")
    void testSave() {
        // Setup our mock repository
       
		
		BidList bid = new BidList("Account Test", "Type Test", 10d);
        doReturn(bid).when(repository).save(any());

        // Execute the service call
        BidList returnedBidlist = service.save(bid);

        // Assert the response
        Assertions.assertNotNull(returnedBidlist, "The saved bidlist should not be null");
        Assertions.assertEquals("Account Test", returnedBidlist.getAccount());
    }
	
	@Test
    @DisplayName("Test findById Success")
    void testFindById() {
        // Setup our mock repository
		BidList bid = new BidList("Account Test", "Type Test", 10d);
        doReturn(Optional.of(bid)).when(repository).findById(6);

        // Execute the service call
        Optional<BidList> returnedBidList = service.findbyId(6);

        // Assert the response
        Assertions.assertTrue(returnedBidList.isPresent(), "BidList was not found");
        Assertions.assertSame(returnedBidList.get(), bid, "The BidList returned was not the same as the mock");
    }
	
	@Test
    @DisplayName("Test findById Not Found")
    void testFindByIdNotFound() {
        // Setup our mock repository
        doReturn(Optional.empty()).when(repository).findById(6);

        // Execute the service call
        Optional<BidList> returnedBidList = service.findbyId(6);

        // Assert the response
        Assertions.assertFalse(returnedBidList.isPresent(), "BidList should not be found");
    }
	
	@Test
    @DisplayName("Test findAll")
    void testFindAll() {
        // Setup our mock repository
		BidList bid1 = new BidList("Account Test", "Type Test", 10d);
		BidList bid2 = new BidList("Account Test2", "Type Test2", 10d);
        doReturn(Arrays.asList(bid1, bid2)).when(repository).findAll();

        // Execute the service call
        java.util.List<BidList> bidLists = service.findAll();

        // Assert the response
        Assertions.assertEquals(2, bidLists.size(), "findAll should return 2 bidList");
    }
}
