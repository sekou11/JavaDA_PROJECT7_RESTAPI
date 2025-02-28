package com.nnk.springboot.controllers;

import java.util.List;

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

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.CurvePointService;

@Controller
public class CurveController {
	// TODO: Inject Curve Point service
	@Autowired
	private CurvePointService curvePointService;
	

private static final Logger LOGGER = LogManager.getLogger(CurveController.class);


	@RequestMapping("/curvePoint/list")
	public String home(Model model) {
		// TODO: find all Curve Point, add to model
		List<CurvePoint> curvePoinnt = curvePointService.AllCurve();
		model.addAttribute("curvePoinnts", curvePoinnt);
		LOGGER.info("All a BidList");
		return "curvePoint/list";
	}

	@GetMapping("/curvePoint/add")
	public String addCurveForm(CurvePoint curvePoint) {
		LOGGER.info("Add a BidList");
		return "curvePoint/add";
	}

	@PostMapping("/curvePoint/validate")
	public String validate(@Valid CurvePoint curvePoint, BindingResult result, Model model) {
		// TODO: check data valid and save to db, after saving return Curve list
		if (!result.hasErrors()) {
			curvePointService.save(curvePoint);
			model.addAttribute("curvePoint", curvePointService.AllCurve());
			LOGGER.info("valide a save a BidList");
			return "redirect:/curvePoint/list";
		}
		return "curvePoint/add";
	}

	@GetMapping("/curvePoint/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		// TODO: get CurvePoint by Id and to model then show to the form
		CurvePoint curvePoint = curvePointService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("invalid CurvePoint id :" + id));
		model.addAttribute("curvePoint", curvePoint);
		LOGGER.info("Update a BidList By id");
		return "curvePoint/update";
	}

	@PostMapping("/curvePoint/update/{id}")
	public String updateBid(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint, BindingResult result,
			Model model) {
		// TODO: check required fields, if valid call service to update Curve and return
		// Curve list
		if (result.hasErrors()) {
			LOGGER.info("Error in a BidList forms");
			return "curvePoint/update";
		}
		curvePoint.setId(id);
		curvePointService.save(curvePoint);
		model.addAttribute("curvePoint", curvePointService.AllCurve());
		LOGGER.info("Update and save a BidList ");
		return "redirect:/curvePoint/list";
	}

	@GetMapping("/curvePoint/delete/{id}")
	public String deleteCurvePoint(@PathVariable("id") Integer id, Model model) {
		// TODO: Find Curve by Id and delete the Curve, return to Curve list
		CurvePoint curvePoint = curvePointService.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("invalid CurvePoint id :" + id));
		  curvePointService.delete(curvePoint);
		  model.addAttribute("curvePoints", curvePointService.AllCurve());
		  LOGGER.info("Delte a BidList ");
		return "redirect:/curvePoint/list";
	}
	
	
   
}
