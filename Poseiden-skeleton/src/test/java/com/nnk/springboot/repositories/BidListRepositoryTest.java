package com.nnk.springboot.repositories;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.domain.BidList;

@SpringBootTest
class BidListRepositoryTest {
	@Autowired
	private BidListRepository bidListRepository;

	@Test
	void bidListTest() {
		BidList bid = new BidList("Account Test", "Type Test", 10d);

		// Save
		bid = bidListRepository.save(bid);
		Assert.assertNotNull(bid.getBidListId());
		Assert.assertEquals(bid.getAccount(), "Account Test");
		Assert.assertEquals(bid.getBidQuantity(), 10d, 10d);
		Assert.assertEquals(bid.getType(), "Type Test");
		Assert.assertNull(bid.getAskQuantity());
		Assert.assertNull(bid.getCreationDate());
		
		// Update 
				bid.setBidQuantity(20d);
				bid.setAccount("update account");
				bid.setAskQuantity(10d);
				bid.setType("type");
				bid = bidListRepository.save(bid);
				Assert.assertEquals(bid.getBidQuantity(), 20d, 20d);
				Assert.assertEquals(bid.getAccount(), "update account");
				Assert.assertEquals(bid.getAskQuantity(), 10d, 10d);
				Assert.assertEquals(bid.getType(), "type");
				
				// Find
				List<BidList> listResult = bidListRepository.findAll();
				Assert.assertTrue(listResult.size() > 0);
				
				
				// Delete
				Integer id = bid.getBidListId();
				bidListRepository.delete(bid);
				Optional<BidList> bidList = bidListRepository.findById(id);
				Assert.assertFalse(bidList.isPresent());

	}

}
