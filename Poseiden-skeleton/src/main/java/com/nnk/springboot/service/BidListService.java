package com.nnk.springboot.service;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.domain.BidList;

public interface BidListService {

	public List<BidList> findAll();

	public BidList save( BidList bid);

	public Optional<BidList> findbyId(Integer id);

	public void delete(int i);
	
	public BidList updateBidList(Integer id,BidList bid);
	
	

}
