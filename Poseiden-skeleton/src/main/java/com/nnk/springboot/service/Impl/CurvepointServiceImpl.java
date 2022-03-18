package com.nnk.springboot.service.Impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
	@Override
	public List<CurvePoint> AllCurve() {
		
		return curvepointRepository.findAll();
	}
	@Override
	public void save(@Valid CurvePoint curvePoint) {
		curvepointRepository.save(curvePoint);
		
		
	}
	@Override
	public Optional<CurvePoint> findById(Integer id) {
		// TODO Auto-generated method stub
		return curvepointRepository.findById(id);
	}
	@Override
	public void delete(CurvePoint curvePoint) {
		curvepointRepository.delete(curvePoint);
		
	}

}
