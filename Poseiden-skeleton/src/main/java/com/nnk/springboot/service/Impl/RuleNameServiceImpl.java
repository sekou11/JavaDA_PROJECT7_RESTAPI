package com.nnk.springboot.service.Impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.service.RuleNameService;
@Service
@Transactional
public class RuleNameServiceImpl implements RuleNameService {
	@Autowired
	private RuleNameRepository ruleNameRepository;
	private static final Logger LOGGER = LogManager.getLogger(RuleNameServiceImpl .class);
	@Override
	public List<RuleName> findAll() {
		LOGGER.debug("All a RuleName List");
		return ruleNameRepository.findAll();
	}

	@Override
	public RuleName save(RuleName ruleName) {
		LOGGER.debug("Save a RuleName"+ruleName);
		return ruleNameRepository.save(ruleName);

	}

	@Override
	public Optional<RuleName> findById(Integer id) {
		LOGGER.debug("Find a RuleName By Id"+id);
		return ruleNameRepository.findById(id);
	}

	@Override
	public void delete(RuleName ruleName) {
		LOGGER.debug("Delete a RuleName " + ruleName);
		ruleNameRepository.delete(ruleName);

	}

	

}
