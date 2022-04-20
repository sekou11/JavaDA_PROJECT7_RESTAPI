package com.nnk.springboot.controllers;

import javax.validation.Valid;

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

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.service.BidListService;

@Controller
public class BidListController {
	@Autowired
	private BidListService bidListService;
	

private static final Logger LOGGER = LogManager.getLogger(BidListController.class);


	@RequestMapping("/bidList/list")
	public String home(Model model) {
		model.addAttribute("bidList", bidListService.findAll());
		LOGGER.info("All a BidList");
		return "bidList/list";
	}

	@GetMapping("/bidList/add")
	public String addBidList(BidList bidList) {
		LOGGER.info("Add a BidList");
		return "bidList/add";
	}

	@PostMapping("/bidList/validate")
	public String validate(@Valid BidList bidList, BindingResult result, Model model) {
		if (!result.hasErrors()) {

			bidListService.save(bidList);
			model.addAttribute("users", bidListService.findAll());
			LOGGER.info("valide A save a BidList");
			return "redirect:/bidList/list";
		}
		return "bidList/add";
	}

	@GetMapping("/bidList/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		BidList bidList = bidListService.findbyId(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid bidList Id:" + id));

		model.addAttribute("bidList", bidList);
		LOGGER.info(" BidList update By id");
		return "bidList/update";
	}

	@PostMapping("/bidList/update/{id}")
	public String updateBidList(@PathVariable("id") Integer id, @Valid BidList bidList, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "bidList/update";
		}
		bidList.setBidListId(id);
		bidListService.save(bidList);
		model.addAttribute("bidList", bidListService.findAll());
		LOGGER.info(" BidList updated and save");
		return "redirect:/bidList/list";
	}
	
	
	 @GetMapping("/bidList/delete/{id}")
	    public String deleteUser(@PathVariable("id") Integer id, Model model) {
	       BidList bidList = bidListService.findbyId(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	        bidListService.delete(id);
	        model.addAttribute("users", bidListService.findAll());
	        LOGGER.info("delete  a BidList");
	        return "redirect:/bidList/list";
	    }

}
