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
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.service.TradeService;


@SpringBootTest

public class TradeServiceTests {
	@Autowired
	private TradeService service;
	@MockBean
	private TradeRepository repository;

	
	@Test
    @DisplayName("Test save trade")
    void testSave() {
        // Setup our mock repository
       
		
		Trade trade = new Trade("Trade Account", "Type", 10d);
        doReturn(trade).when(repository).save(any());

        // Execute the service call
        Trade returnedTrade = service.save(trade);

        // Assert the response
        Assertions.assertNotNull(returnedTrade, "The saved trade should not be null");
        Assertions.assertEquals("Trade Account", returnedTrade.getAccount());
    }
	
	@Test
    @DisplayName("Test findById Success")
    void testFindById() {
        // Setup our mock repository
		Trade trade = new Trade("Trade Account", "Type", 10d);
        doReturn(Optional.of(trade)).when(repository).findById(6);

        // Execute the service call
        Optional<Trade> returnedTrade = service.findbyId(6);

        // Assert the response
        Assertions.assertTrue(returnedTrade.isPresent(), "Trade was not found");
        Assertions.assertSame(returnedTrade.get(), trade, "The Trade returned was not the same as the mock");
    }
	
	@Test
    @DisplayName("Test findById Not Found")
    void testFindByIdNotFound() {
        // Setup our mock repository
        doReturn(Optional.empty()).when(repository).findById(6);

        // Execute the service call
        Optional<Trade> returnedTrade = service.findbyId(6);

        // Assert the response
        Assertions.assertFalse(returnedTrade .isPresent(), "Trade should not be found");
    }
	
	@Test
    @DisplayName("Test findAll")
    void testFindAll() {
        // Setup our mock repository
		Trade trade1 = new Trade("Trade Account", "Type", 10d);
		Trade trade2 = new Trade("Trade Account2", "Type2", 10d);
        doReturn(Arrays.asList(trade1, trade2)).when(repository).findAll();

        // Execute the service call
        java.util.List<Trade> trades = service.findAll();

        // Assert the response
        Assertions.assertEquals(2, trades.size(), "findAll should return 2 trades");
    }
	
	@Test
    @DisplayName("Test delete trade Success")
    void testDelete() {
        // Setup our mock repository
		Trade trade = new Trade();
		service.delete(trade);
		service.delete(trade);
		
		verify(repository ,times(2)).delete(trade);;
}
}
