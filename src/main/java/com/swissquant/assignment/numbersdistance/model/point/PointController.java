package com.swissquant.assignment.numbersdistance.model.point;

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
	
	Logger LOG = Logger.getLogger(PointController.class);
	
	@Inject
	private PointService pointService;
	
	@RequestMapping(method = RequestMethod.POST, path = "/points/findClosestPointsTo")
	public List<Point> findClosestPointsTo(@RequestBody Point point, @PathParam("resultSetSize") int resultSetSize) {
		LOG.info("finding closest point to Point: " + point + " resultSetSize: " + resultSetSize);
		return pointService.findClosestPointsTo(point, resultSetSize);
	}
		
	@RequestMapping(method = RequestMethod.POST, path = "/points/findFurthestPointsTo")
	public List<Point> findFurthestPointsTo(@RequestBody Point point, @PathParam("resultSetSize") int resultSetSize) {
		LOG.info("finding furthest point to Point: " + point + " resultSetSize: " + resultSetSize);
		return pointService.findFurthestPointsTo(point, resultSetSize);
	}

}
