package edu.swissq.assignment.numbersdistance.resource;

import java.text.MessageFormat;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.swissq.assignment.numbersdistance.model.Point;
import edu.swissq.assignment.numbersdistance.service.PointService;

/**
 * Controller/Resource which handles requests from a REST client.
 * 
 * @author Frank Sprich
 *
 */
@RestController
public class PointControllerRs {
	
	private Logger LOG = Logger.getLogger(PointControllerRs.class);
	
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
	 * @param givenPoint the point for which the furthest points from the pointUnivers should be found
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
	
	/**
	 * REST method - creates the point universe file originally named "points" now fileName.
	 * 
	 * @param pointsInUnverse
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/points/createPointUniverseFile")
	public Response createPointUniverseFile(@PathParam("pointsInUniverse") int pointsInUniverse, @PathParam("fileName") String fileName) {
		long start = System.currentTimeMillis();
		/* There are two coordinates for a point in the point universe */
		pointService.createPointUniverse(pointsInUniverse * 2, fileName);
		long duration = System.currentTimeMillis() - start;
		String info = MessageFormat.format("The processing duration ot this call is {0}ms", duration);
		LOG.info(info);
		return Response.ok(info).build();
	}

}
