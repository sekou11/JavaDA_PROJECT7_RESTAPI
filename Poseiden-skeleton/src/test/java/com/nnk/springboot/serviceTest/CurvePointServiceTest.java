package com.nnk.springboot.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import com.nnk.springboot.domain.CurvePoint;

import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.service.CurvePointService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurvePointServiceTest {
	@Autowired
	private CurvePointService curvePointService;
	@Autowired
	private CurvePointRepository curvePointRepository;

	@WithMockUser(value = "test")
	@Test
	public void CurvepointServiceTest() {
		CurvePoint curvePoint = new CurvePoint(10, 10d, 30d);

		// Save

		curvePointService.save(curvePoint);
		Assert.assertNotNull(curvePoint.getId());
		Assert.assertTrue(curvePoint.getCurveId() == 10);

		// Update

		Integer id2 = curvePoint.getId();
		curvePointService.findById(id2);
		curvePoint.setCurveId(20);
		curvePoint = curvePointService.updateCurvePoint(id2, curvePoint);
		Assert.assertTrue(curvePoint.getCurveId() == 20);

		// Find

		List<CurvePoint> listResult = curvePointService.AllCurve();
		Assert.assertTrue(listResult.size() > 0);

		// Delete
		
		Integer id = curvePoint.getId();
		curvePointService.delete(curvePoint);
		Optional<CurvePoint> curvePointList = curvePointRepository.findById(id);
		Assert.assertFalse(curvePointList.isPresent());
		
		
		
		  
		  
		  
		  
		 
	}

}