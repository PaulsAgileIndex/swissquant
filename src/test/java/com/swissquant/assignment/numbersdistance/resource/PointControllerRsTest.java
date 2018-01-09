package com.swissquant.assignment.numbersdistance.resource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.swissquant.assignment.numbersdistance.model.Point;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PointControllerRsTest {

	@Autowired
	private PointControllerRs controller;
	
    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
    
    @Test
    public void testFindClosestPointsTo() {
    	/* Assignment: The 10 closest points from (-200, 300) */
    	int resultSetSize = 10;
    	Point givenPoint = new Point(-200, 300);
    	
    	List<Point> resultList = controller.findClosestPointsTo(givenPoint, resultSetSize, "useDefaultAlgorithm");
    	assertThat(resultList).isNotNull().isNotEmpty();
    	assertThat(resultList).hasSize(resultSetSize);
    }
    
    @Test
    public void findFurthestPointsTo() {
    	/* Assignment: The 20 furthest points from (1000, 25) */
    	int resultSetSize = 20;
    	Point givenPoint = new Point(1000, 25);
    	
    	List<Point> resultList = controller.findFurthestPointsTo(givenPoint, resultSetSize, "useDefaultAlgorithm");
    	assertThat(resultList).isNotNull().isNotEmpty();
    	assertThat(resultList).hasSize(resultSetSize);
    }

}
