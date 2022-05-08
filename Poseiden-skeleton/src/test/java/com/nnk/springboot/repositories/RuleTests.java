package com.nnk.springboot.repositories;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.domain.RuleName;


@SpringBootTest
public class RuleTests {
	@Autowired
	private RuleNameRepository ruleNameRepository;


	@Test
	public void ruleTest() {
		RuleName rule = new RuleName("Rule Name", "Description", "Json", "Template", "SQL", "SQL Part");

		// Save
		rule = ruleNameRepository.save(rule);
		Assert.assertNotNull(rule.getId());
		Assert.assertTrue(rule.getName().equals("Rule Name"));
		Assert.assertTrue(rule.getDescription().equals("Description"));
		Assert.assertTrue(rule.getSqlPart().equals("SQL Part"));
		Assert.assertTrue(rule.getSqlStr().equals("SQL"));
		Assert.assertTrue(rule.getTemplate().equals("Template"));
		Assert.assertTrue(rule.getJson().equals("Json"));
		// Update
		rule.setName("Rule Name Update");
		rule.setDescription("description");
		rule.setJson("json");
		rule.setSqlPart("sqlPart");
		rule.setSqlStr("sqlStr");
		rule.setTemplate("template");

		rule = ruleNameRepository.save(rule);
		Assert.assertTrue(rule.getName().equals("Rule Name Update"));
		Assert.assertTrue(rule.getDescription().equals("description"));
		Assert.assertTrue(rule.getSqlPart().equals("sqlPart"));
		Assert.assertTrue(rule.getSqlStr().equals("sqlStr"));
		Assert.assertTrue(rule.getTemplate().equals("template"));
		Assert.assertTrue(rule.getJson().equals("json"));

		// Find
		List<RuleName> listResult = ruleNameRepository.findAll();
		Assert.assertTrue(listResult.size() > 0);

//		// Delete
//		Integer id = rule.getId();
//		ruleNameRepository.delete(rule);
//		Optional<RuleName> ruleList = ruleNameRepository.findById(id);
//		Assert.assertFalse(ruleList.isPresent());
	}
}
