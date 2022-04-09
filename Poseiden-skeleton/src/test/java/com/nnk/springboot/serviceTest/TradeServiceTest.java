package com.nnk.springboot.serviceTest;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.service.TradeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TradeServiceTest {
	@Autowired
	private TradeRepository tradeRepository;
	@Autowired
	private TradeService tradeService;

	@WithMockUser(value = "test")
	@Test
	public void tradeServiceTest() {
		Trade trade = new Trade("Trade Account", "Type", 10d);

		// Save
		tradeService.save(trade);
		Assert.assertNotNull(trade.getTradeId());
		Assert.assertTrue(trade.getAccount().equals("Trade Account"));

		// Update
		Integer id = trade.getTradeId();
		tradeService.findbyId(id);
		trade.setAccount("Trade Account Update");
		tradeService.updateTrade(id, trade);
		Assert.assertTrue(trade.getAccount().equals("Trade Account Update"));

		// Find
		List<Trade> listResult = tradeService.findAll();
		Assert.assertTrue(listResult.size() > 0);

		// Delete

		
		  
		
		Integer id2 = trade.getTradeId();
		tradeService.delete(trade);
		Optional<Trade> tradeList = tradeRepository.findById(id2);
		Assert.assertFalse(tradeList.isPresent());

	}
}
