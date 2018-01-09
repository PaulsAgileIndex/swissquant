package com.swissquant.assignment.numbersdistance.model;

import java.text.MessageFormat;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.PathParam;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller/Resource which handles requests from a REST client.
 * 
 * @author Frank Sprich
 *
 */
@RestController
public class PointController {
	
	private Logger LOG = Logger.getLogger(PointController.class);
	
	@Inject
	private PointService pointService;
	
	/**
	 * REST method to handle request for closest points.
	 *  
	 * @param givenPoint the point for which the closests points from the pointUnivers should be found
	 * @param resultSetSize the size of the result set
	 * @param algoName name of the algorithm
	 * @return List of Points
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/points/findClosestPointsTo")
	public List<Point> findClosestPointsTo(@RequestBody Point givenPoint, @PathParam("resultSetSize") int resultSetSize, @PathParam("algoName") String algoName) {		
		long start = System.currentTimeMillis();
		List<Point> resultList = pointService.findClosestPointsTo(givenPoint, resultSetSize, algoName);	
		StringBuilder sb = new StringBuilder();
		resultList.forEach(p -> sb.append("\n" + p));
		long duration = System.currentTimeMillis() - start;
		LOG.info(MessageFormat.format("Finding closest point to {0} resultSetSize: {1} in {2} ms \nResult list: {3}", givenPoint, resultSetSize, duration, sb.toString()));
		return resultList;
	}
		
	/**
	 * REST method to handle request for furthest points.
	 * 
	 * @param givenPoint the point for which the closests points from the pointUnivers should be found
	 * @param resultSetSize the size of the result set
	 * @param algoName name of the algorithm
	 * @return List of Points
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/points/findFurthestPointsTo")
	public List<Point> findFurthestPointsTo(@RequestBody Point givenPoint, @PathParam("resultSetSize") int resultSetSize, @PathParam("algoName") String algoName) {		
		long start = System.currentTimeMillis();
		List<Point> resultList = pointService.findFurthestPointsTo(givenPoint, resultSetSize, algoName);
		StringBuilder sb = new StringBuilder();
		resultList.forEach(p -> sb.append("\n" + p));
		long duration = System.currentTimeMillis() - start;
		LOG.info(MessageFormat.format("Finding furthest point to {0} resultSetSize: {1} in {2} ms \nResult list: {3}", givenPoint, resultSetSize, duration, sb.toString()));
		return resultList;
	}

}
