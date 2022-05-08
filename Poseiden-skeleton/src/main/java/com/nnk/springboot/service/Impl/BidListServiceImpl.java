package com.nnk.springboot.service.Impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	private static final Logger LOGGER = LogManager.getLogger(BidListServiceImpl.class);
	@Override
	public List<BidList> findAll() {
		 LOGGER.debug("All BidList called");
		return bidListRepository.findAll();
	}

	@Override
	public BidList save(BidList bidList) { 
		LOGGER.debug("A bildList save" +bidList);
		return bidListRepository.save(bidList);
		
	}

	@Override
	public Optional<BidList> findbyId(Integer id) {
		LOGGER.debug("A bildList found" +id);
		return bidListRepository.findById(id);
	}
	
	

	@Override
	public void delete(BidList bidList) {
		 LOGGER.debug("delete a bidList By bidList" + bidList);
		bidListRepository.delete(bidList);		  
	}

	
	
	
	


	

}