package com.nnk.springboot.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.service.TradeService;
@Service
@Transactional
public class TradeServiceImpl implements TradeService {
	@Autowired
	private TradeRepository tradeRepository;

	@Override
	public List<Trade> findAll() {
		return tradeRepository.findAll();
	}

	@Override
	public void save(Trade trade) {
		tradeRepository.save(trade);
		
	}

	@Override
	public Optional<Trade> findbyId(Integer id) {
		return tradeRepository.findById(id);
	}

	@Override
	public void delete(Trade tradeList) {
		tradeRepository.delete(tradeList);
		
	}  




}