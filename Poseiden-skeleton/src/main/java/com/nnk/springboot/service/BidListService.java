package com.nnk.springboot.service;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.Rating;

public interface BidListService {

	public List<BidList> findAll();

	public BidList save( BidList bid);

	public Optional<BidList> findbyId(Integer id);

	public void delete(BidList bidList);
	
	

	
	
	

}
