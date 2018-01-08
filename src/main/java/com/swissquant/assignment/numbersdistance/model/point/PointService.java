package com.swissquant.assignment.numbersdistance.model.point;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class PointService {
	
	private Logger LOG = Logger.getLogger(PointService.class);
	
	@Inject
	private PointReader reader;
	
	public List<Point> readAllPoints() {
		
		LOG.info("reader.readFile(): " +reader.getCachedPointsMap());
		
		List<Point> list = new ArrayList<>();
		Point p = new Point(5,6);
		list.add(p);
		return list;
	}
	
	public List<Point> findClosestPointsTo(Point p, int resultSetSize) {		
		return readAllPoints();
	}
	
	public List<Point> findFurthestPointsTo(Point p, int resultSetSize) {
		return readAllPoints();
	}

}
