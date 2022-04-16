package com.nnk.springboot.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.service.TradeService;
@Service
@Transactional
public class TradeServiceImpl implements TradeService {
	@Autowired
	private TradeRepository tradeRepository;
	
	private static final Logger LOGGER = LogManager.getLogger(TradeServiceImpl.class);

	@Override
	public List<Trade> findAll() {
		 LOGGER.debug("All Trade called");
		return tradeRepository.findAll();
	}

	@Override
	public void save(Trade trade) {
		 LOGGER.debug("A trade save" +trade);
		tradeRepository.save(trade);
		
	}

	@Override
	public Optional<Trade> findbyId(Integer id) {
		 LOGGER.debug("find a trade By id" + id);
		return tradeRepository.findById(id);
	}

	@Override
	public void delete(Trade tradeId) {
		 LOGGER.debug("delete a trade by id" +tradeId);
		tradeRepository.delete(tradeId);
		
	}

	@Override
	
	public Trade updateTrade(Integer id, Trade trade) {
		 LOGGER.debug("Update a Trade by id" +trade);
		trade.setTradeId(id);
		tradeRepository.save(trade);
		return trade;
		
		
	}  




}