package com.nnk.springboot.service;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.domain.RuleName;

public interface RuleNameService {

	public List<RuleName> findAll();

	public RuleName save(RuleName ruleName);

	public Optional<RuleName> findById(Integer id);

	public void delete(RuleName ruleName);

	public RuleName updateRuleName(Integer id, RuleName rule);
	
	


	


}
