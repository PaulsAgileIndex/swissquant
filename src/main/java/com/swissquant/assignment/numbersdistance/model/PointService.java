package com.swissquant.assignment.numbersdistance.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.swissquant.assignment.numbersdistance.reader.PointReader;

@Service
public class PointService {
	
	@Inject
	private PointReader reader;
	
	private ConcurrentHashMap<Integer, Point> cachedPointsMap; 
	
	
	/**
	 * Compute closest points to given Point and resultSetSize.
	 * 
	 * @param givenPoint Point provided
	 * @param resultSetSize result set size
	 * @return List of closest Points 
	 */
	public List<Point> findClosestPointsTo(Point givenPoint, int resultSetSize) {	
		List<Point> resultList = new ArrayList<>();
		cachedPointsMap = reader.getCachedPointsMap();
		
//		Point p1 = new Point(5,6);
//		resultList.add(p1);
		return resultList;
	}
	
	/**
	 * Compute furthest points to given Point and resultSetSize.
	 * 
	 * @param givenPoint Point provided
	 * @param resultSetSize result set size
	 * @return List of furthest Points 
	 */
	public List<Point> findFurthestPointsTo(Point givenPoint, int resultSetSize) {
		List<Point> resultList = new ArrayList<>();
		cachedPointsMap = reader.getCachedPointsMap();
		
//		Point p1 = new Point(5,6);
//		resultList.add(p1);
		return resultList;
	}

}
