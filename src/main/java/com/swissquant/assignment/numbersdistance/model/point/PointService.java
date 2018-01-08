package com.swissquant.assignment.numbersdistance.model.point;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PointService {
	
	public List<Point> readAllPoints() {
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
