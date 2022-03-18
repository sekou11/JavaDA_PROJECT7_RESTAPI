package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.service.Impl.BidListServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class BidListController {
	@Autowired
	private BidListServiceImpl bidListService;

	@RequestMapping("/bidList/list")
	public String home(Model model) {
		model.addAttribute("bidList", bidListService.findAll());
		return "bidList/list";
	}

	@GetMapping("/bidList/add")
	public String addBidList(BidList bidList) {
		return "bidList/add";
	}

	@PostMapping("/bidList/validate")
	public String validate(@Valid BidList bidList, BindingResult result, Model model) {
		if (!result.hasErrors()) {

			bidListService.save(bidList);
			model.addAttribute("users", bidListService.findAll());
			return "redirect:/bidList/list";
		}
		return "bidList/add";
	}

	@GetMapping("/bidList/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		BidList bidList = bidListService.findbyId(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid bidList Id:" + id));

		model.addAttribute("bidList", bidList);
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
		return "redirect:/bidList/list";
	}
	
	
	 @GetMapping("/bidList/delete/{id}")
	    public String deleteUser(@PathVariable("id") Integer id, Model model) {
	       BidList bidList = bidListService.findbyId(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	        bidListService.delete(bidList);
	        model.addAttribute("users", bidListService.findAll());
	        return "redirect:/bidList/list";
	    }

}
