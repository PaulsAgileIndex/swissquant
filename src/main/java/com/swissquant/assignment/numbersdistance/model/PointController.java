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

@RestController
public class PointController {
	
	private Logger LOG = Logger.getLogger(PointController.class);
	
	@Inject
	private PointService pointService;
	
	@RequestMapping(method = RequestMethod.POST, path = "/points/findClosestPointsTo")
	public List<Point> findClosestPointsTo(@RequestBody Point givenPoint, @PathParam("resultSetSize") int resultSetSize, @PathParam("algoName") String algoName) {		
		List<Point> resultList = pointService.findClosestPointsTo(givenPoint, resultSetSize, algoName);	
		StringBuilder sb = new StringBuilder();
		resultList.forEach(p -> sb.append("\n" + p));
		LOG.info(MessageFormat.format("Finding closest point to {0} resultSetSize: {1} \nResult list: {2}", givenPoint, resultSetSize, sb.toString()));
		return resultList;
	}
		
	@RequestMapping(method = RequestMethod.POST, path = "/points/findFurthestPointsTo")
	public List<Point> findFurthestPointsTo(@RequestBody Point givenPoint, @PathParam("resultSetSize") int resultSetSize, @PathParam("algoName") String algoName) {		
		List<Point> resultList = pointService.findFurthestPointsTo(givenPoint, resultSetSize, algoName);
		StringBuilder sb = new StringBuilder();
		resultList.forEach(p -> sb.append("\n" + p));
		LOG.info(MessageFormat.format("Finding furthest point to {0} resultSetSize: {1} \nResult list: {2}", givenPoint, resultSetSize, sb.toString()));
		return resultList;
	}

}
