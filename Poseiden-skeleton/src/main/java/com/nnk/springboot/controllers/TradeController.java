package com.nnk.springboot.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.TradeService;

@Controller
public class TradeController {
	// TODO: Inject Trade service
	@Autowired
	private TradeService tradeService;
	
	private static final Logger LOGGER = LogManager.getLogger(TradeController.class);

	@RequestMapping("/trade/list")
	public String home(Model model) {
		// TODO: find all Trade, add to model
		List<Trade> trades = tradeService.findAll();
		model.addAttribute("trades", trades);
		LOGGER.info("All trades");
		return "trade/list";
	}

	@GetMapping("/trade/add")
	public String addTrade(Trade trade) {
		LOGGER.info("Add a Trade");
		return "trade/add";
	}

	@PostMapping("/trade/validate")
	public String validate(@Valid Trade trade, BindingResult result, Model model) {
		// TODO: check data valid and save to db, after saving return Trade list
		if (!result.hasErrors()) {
			tradeService.save(trade);
			model.addAttribute("trade", tradeService.findAll());
			LOGGER.info("validate a Trade");
			return "redirect:/trade/list";
		}
		return "trade/add";
	}

	@GetMapping("/trade/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		// TODO: get Trade by Id and to model then show to the form
		Trade trade = tradeService.findbyId(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Trade Id " + id));
		model.addAttribute("trade", trade);
		LOGGER.info("updated a Trade by id"+ id);
		return "trade/update";
	}

	@PostMapping("/trade/update/{id}")
	public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade, BindingResult result, Model model) {
		// TODO: check required fields, if valid call service to update Trade and return
		// Trade list
		if (result.hasErrors()) {
			return "trade/update";
		}
		trade.setTradeId(id);
		tradeService.save(trade);
		model.addAttribute("rating", tradeService.findAll());
		LOGGER.info("updated and saved Trade ");
		return "redirect:/trade/list";

		
	}

	@GetMapping("/trade/delete/{id}")
	public String deleteTrade(@PathVariable("id") Integer id, Model model) {
		// TODO: Find Trade by Id and delete the Trade, return to Trade list
		Trade trade = tradeService.findbyId(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Trade Id " + id));
		tradeService.delete(trade);
		model.addAttribute("trade", tradeService.findAll());
		LOGGER.info(" Trade delete");
		return "redirect:/trade/list";
	}
}
