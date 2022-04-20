package com.nnk.springboot.ServiceTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.service.RuleNameService;


@SpringBootTest

public class RuleServiceTests {
	@Autowired
	private RuleNameService service;
	@MockBean
	private RuleNameRepository repository;

	
	@Test
    @DisplayName("Test save ruleName")
    void testSave() {
        // Setup our mock repository
       
		
		RuleName rule = new RuleName("Rule Name", "Description", "Json", "Template", "SQL", "SQL Part");
        doReturn(rule).when(repository).save(any());

        // Execute the service call
        RuleName returnedRule = service.save(rule);

        // Assert the response
        Assertions.assertNotNull(returnedRule, "The saved rule should not be null");
        Assertions.assertEquals("Rule Name", returnedRule.getName());
    }
	
	@Test
    @DisplayName("Test findById Success")
    void testFindById() {
        // Setup our mock repository
		RuleName rule = new RuleName("Rule Name", "Description", "Json", "Template", "SQL", "SQL Part");
        doReturn(Optional.of(rule)).when(repository).findById(6);

        // Execute the service call
        Optional<RuleName> returnedRule = service.findById(6);

        // Assert the response
        Assertions.assertTrue(returnedRule.isPresent(), "Rule was not found");
        Assertions.assertSame(returnedRule.get(), rule, "The Rule returned was not the same as the mock");
    }
	
	@Test
    @DisplayName("Test findById Not Found")
    void testFindByIdNotFound() {
        // Setup our mock repository
        doReturn(Optional.empty()).when(repository).findById(6);

        // Execute the service call
        Optional<RuleName> returnedRating = service.findById(6);

        // Assert the response
        Assertions.assertFalse(returnedRating .isPresent(), "Rule should not be found");
    }
	
	@Test
    @DisplayName("Test findAll")
    void testFindAll() {
        // Setup our mock repository
		RuleName rule1 = new RuleName("Rule Name", "Description", "Json", "Template", "SQL", "SQL Part");
		RuleName rule2 = new RuleName("Rule Name2", "Description2", "Json2", "Template2", "SQL2", "SQL Part2");
        doReturn(Arrays.asList(rule1, rule2)).when(repository).findAll();

        // Execute the service call
        java.util.List<RuleName> rules = service.findAll();

        // Assert the response
        Assertions.assertEquals(2, rules.size(), "findAll should return 2 rating");
    }
}
