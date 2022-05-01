package com.nnk.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.nnk.springboot.domain.CurvePoint;

public interface CurvePointService {
	
	public List<CurvePoint>AllCurve();

	public CurvePoint save(@Valid CurvePoint curvePoint);

	public Optional<CurvePoint> findById(Integer id);

	public void delete(CurvePoint curvePoint );

	


}
