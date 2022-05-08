package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.service.RuleNameService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.validation.Valid;

@Controller
public class RuleNameController {
    // TODO: Inject RuleName service
	@Autowired
	private RuleNameService ruleNameService;
	
	private static final Logger LOGGER = LogManager.getLogger(TradeController.class);

    @RequestMapping("/ruleName/list")
    public String home(Model model)
    {
    	List<RuleName> ruleName =ruleNameService.findAll();
        // TODO: find all RuleName, add to model
    	model.addAttribute("ruleName", ruleName);
    	LOGGER.info("All RuleName");
        return "ruleName/list";
    }

    @GetMapping("/ruleName/add")
    public String addRuleForm(RuleName ruleName) {
    	LOGGER.info("Add a trade");
        return "ruleName/add";
    }

    @PostMapping("/ruleName/validate")
    public String validate(@Valid RuleName ruleName, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return RuleName list
    	if (!result.hasErrors()) {
			ruleNameService.save(ruleName);
			model.addAttribute("ruleName", ruleNameService.findAll());
			LOGGER.info("Validate and Save a trade");
			return "redirect:/ruleName/list";
		}
        return "ruleName/add";
    }

    @GetMapping("/ruleName/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get RuleName by Id and to model then show to the form
    	RuleName ruleName = ruleNameService.findById(id)
    			.orElseThrow(()->new IllegalArgumentException("Invalid RuleName id"+id));
    	 model.addAttribute("ruleName", ruleName);
    	 LOGGER.info("Update a trade By id");
        return "ruleName/update";
    }

    @PostMapping("/ruleName/update/{id}")
    public String updateRuleName(@PathVariable("id") Integer id, @Valid RuleName ruleName,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update RuleName and return RuleName list
    	  if (result.hasErrors()) {
			return "ruleName/update";
		}
    	  ruleName.setId(id);
    	  ruleNameService.save(ruleName);
    	  model.addAttribute("ruleName", ruleName);
    	  LOGGER.info("Update and Save a trade ");
        return "redirect:/ruleName/list";
    }

    @GetMapping("/ruleName/delete/{id}")
    public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
        // TODO: Find RuleName by Id and delete the RuleName, return to Rule list
    	
    	RuleName ruleName = ruleNameService.findById(id)
    			.orElseThrow(()->new IllegalArgumentException("Invalid RuleName id"+id));
    	   ruleNameService.delete(ruleName);
    	   model.addAttribute("ruleName", ruleName);
    	   LOGGER.info("Delete a trade .......");
        return "redirect:/ruleName/list";
    }
}
