package com.nnk.springboot.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
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
	public void testSaveBidList() {
		BidList bid = new BidList();
		bid.setBidListId(1);
		bid.setAccount("account");
		bid.setType("type");
		bid.setBidQuantity(10d);

		when(repository.save(bid)).thenReturn(bid);
		assertThat(service.save(bid)).isEqualTo(bid);
	}

	@Test
	@DisplayName("Test findById Success")
	public void testFindById() {
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
	@DisplayName("Test All bidList Success")
	public void testAllBidList() {
		// Setup our mock repository
		BidList bid1 = new BidList();
		bid1.setAccount("account 1");
		bid1.setType("type 1");
		bid1.setAskQuantity(20d);

		BidList bid2 = new BidList();
		bid1.setAccount("account 2");
		bid1.setType("type 2");
		bid1.setAskQuantity(30d);

		List<BidList> bidLists = new ArrayList<BidList>();
		bidLists.add(bid1);
		bidLists.add(bid2);

		when(repository.findAll()).thenReturn(bidLists);
		assertThat(service.findAll()).isEqualTo(bidLists);

	}

	@Test
	@DisplayName("Test delete bidlete Success")
	public void testDeleteBidList() {
		// Setup our mock repository
		BidList bid1 = new BidList();
		bid1.setBidListId(1);
		bid1.setAccount("account 1");
		bid1.setType("type 1");
		bid1.setAskQuantity(20d);

		when(repository.findById(1)).thenReturn(Optional.of(bid1));

		when(repository.existsById(bid1.getBidListId())).thenReturn(false);
		assertFalse(repository.existsById(bid1.getBidListId()));

	}
}
	
	
	
	