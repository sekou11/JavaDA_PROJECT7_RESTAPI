package com.nnk.springboot.service.Impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.service.CurvePointService;
@Service
@Transactional
public class CurvepointServiceImpl implements CurvePointService {
	@Autowired
 private CurvePointRepository curvepointRepository;
	private static final Logger LOGGER = LogManager.getLogger(CurvepointServiceImpl.class);
	@Override
	public List<CurvePoint> AllCurve() {
		LOGGER.debug("All Curve");
		return curvepointRepository.findAll();
		 
	}
	@Override
	public void save(@Valid CurvePoint curvePoint) {
		LOGGER.debug("Save a Curve");
		curvepointRepository.save(curvePoint);
		
		
	}
	@Override
	public Optional<CurvePoint> findById(Integer id) {
		LOGGER.debug("Find a Curve By Id" +id);
		return curvepointRepository.findById(id);
	}
	@Override
	public void delete(CurvePoint curvePoint) {
		LOGGER.debug("Delete a Curve"+ curvePoint);
		curvepointRepository.delete(curvePoint);
		
	}
	@Override
	public CurvePoint updateCurvePoint(Integer id2, CurvePoint curvePoint) {
		LOGGER.debug("Delete a CurvePoint" +curvePoint);
       curvePoint.setId(id2);
       curvepointRepository.save(curvePoint);
		return curvePoint;
	}

}
