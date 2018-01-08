package com.swissquant.assignment.numbersdistance.model.point;

import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Named;

@Named
public class PointReader {
	
	private ConcurrentHashMap<Integer, Point> pointsCache;
	
	/**
	 * Read data from file only once during runtime.
	 * 
	 * @return ConcurrentHashMap all data from file
	 */
	public ConcurrentHashMap<Integer, Point> getCachedPointsMap() {
		if (null == pointsCache) {
			pointsCache = new ConcurrentHashMap<>();
		}
		
		if (pointsCache.isEmpty()) {
			readFile();
		}		
		return pointsCache;
	}
	
	public void readFile() {
		
		
		
		Point p1 = new Point(5,7);
		Point p2 = new Point(5,7);
		Point p3 = new Point(5,7);
		Point p4 = new Point(10,700);
		pointsCache.put(p1.hashCode(), p1);
		pointsCache.put(p2.hashCode(), p2);
		pointsCache.put(p3.hashCode(), p3);
		pointsCache.put(p4.hashCode(), p4);
	}

}
