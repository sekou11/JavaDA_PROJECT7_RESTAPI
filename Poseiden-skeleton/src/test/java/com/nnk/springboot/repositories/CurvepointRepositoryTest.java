package com.nnk.springboot.repositories;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.domain.CurvePoint;

@SpringBootTest
public class CurvepointRepositoryTest {
	@Autowired
	private CurvePointRepository curvePointRepository;
	
	@Test
	public void curvePointTest() {
		CurvePoint curvePoint = new CurvePoint(10, 10d, 30d);

		// Save

		curvePoint = curvePointRepository.save(curvePoint);

		Assert.assertNotNull(curvePoint.getId());
		Assert.assertTrue(curvePoint.getCurveId() == 10);
		Assert.assertTrue(curvePoint.getTerm() == 10d);
		Assert.assertTrue(curvePoint.getValue() == 30d);

		// Update

		curvePoint.setCurveId(20);
		curvePoint.setTerm(20d);
		curvePoint.setValue(100d);
		curvePoint = curvePointRepository.save(curvePoint);
		Assert.assertTrue(curvePoint.getCurveId() == 20);
		Assert.assertTrue(curvePoint.getTerm() == 20d);
		Assert.assertTrue(curvePoint.getValue() == 100d);

		// Find

		List<CurvePoint> listResult = curvePointRepository.findAll();
		Assert.assertTrue(listResult.size() > 0);

		// Delete

		Integer id = curvePoint.getId();
		curvePointRepository.delete(curvePoint);
		Optional<CurvePoint> curvePointList = curvePointRepository.findById(id);
		Assert.assertFalse(curvePointList.isPresent());

	}

}
