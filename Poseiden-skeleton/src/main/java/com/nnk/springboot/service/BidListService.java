package com.nnk.springboot.service;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.domain.BidList;

public interface BidListService {

	public List<BidList> findAll();

	public void save( BidList bid);

	public Optional<BidList> findbyId(Integer id);

	public void delete(BidList bidList);

}
