package com.nnk.springboot.service;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.domain.Trade;

public interface TradeService {

	public List<Trade> findAll();

	public void save( Trade trade);

	public Optional<Trade> findbyId(Integer id);

	public void delete(Trade tradeList);

}
