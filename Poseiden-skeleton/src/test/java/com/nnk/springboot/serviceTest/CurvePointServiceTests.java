package com.nnk.springboot.ServiceTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.service.CurvePointService;


@SpringBootTest

public class CurvePointServiceTests {
	@Autowired
	private CurvePointService service;
	@MockBean
	private CurvePointRepository repository;

	
	@Test
    @DisplayName("Test save CurvePoint")
    void testSave() {
        // Setup our mock repository
       
		CurvePoint curvePoint = new CurvePoint(10, 10d, 30d);
		
        doReturn(curvePoint).when(repository).save(any());

        // Execute the service call
        CurvePoint returnedCurvePoint = service.save(curvePoint);

        // Assert the response
        Assertions.assertNotNull(returnedCurvePoint, "The saved Curvepoint should not be null");
        Assertions.assertEquals(10, returnedCurvePoint.getCurveId());
    }
	
	@Test
    @DisplayName("Test findById Success")
    void testFindById() {
        // Setup our mock repository
		CurvePoint curvePoint = new CurvePoint(10, 10d, 30d);
        doReturn(Optional.of(curvePoint)).when(repository).findById(10);

        // Execute the service call
        Optional<CurvePoint> returnedCurvePoint = service.findById(10);

        // Assert the response
        Assertions.assertTrue(returnedCurvePoint.isPresent(), "BidList was not found");
        Assertions.assertSame(returnedCurvePoint.get(), curvePoint, "The BidList returned was not the same as the mock");
    }
	
	@Test
    @DisplayName("Test findById Not Found")
    void testFindByIdNotFound() {
        // Setup our mock repository
        doReturn(Optional.empty()).when(repository).findById(6);

        // Execute the service call
        Optional<CurvePoint> returnedBidList = service.findById(6);

        // Assert the response
        Assertions.assertFalse(returnedBidList.isPresent(), "CurvePoint should not be found");
    }
	
	@Test
    @DisplayName("Test findAll")
    void testFindAll() {
        // Setup our mock repository
		CurvePoint curvePoint1 = new CurvePoint(10, 10d, 30d);
		CurvePoint curvePoint2 = new CurvePoint(10, 10d, 30d);
        doReturn(Arrays.asList(curvePoint1, curvePoint2)).when(repository).findAll();

        // Execute the service call
        java.util.List<CurvePoint> curvePoints = service.AllCurve();

        // Assert the response
        Assertions.assertEquals(2, curvePoints.size(), "findAll should return 2 CurvePoints");
    }
}
