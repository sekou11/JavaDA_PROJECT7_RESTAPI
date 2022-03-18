package com.nnk.springboot.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.service.BidListService;
@Service
@Transactional
public class BidListServiceImpl implements BidListService {
	@Autowired
	private BidListRepository bidListRepository;  

	@Override
	public List<BidList> findAll() {
		// TODO Auto-generated method stub
		return bidListRepository.findAll();
	}

	@Override
	public void save(BidList bid) {
		bidListRepository.save(bid);
		
	}

	@Override
	public Optional<BidList> findbyId(Integer id) {
		// TODO Auto-generated method stub
		return bidListRepository.findById(id);
	}

	@Override
	public void delete(BidList bidList) {
		bidListRepository.delete(bidList);		
	}

}