package com.swissquant.assignment.numbersdistance.algorith.bruteforce;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import com.swissquant.assignment.numbersdistance.algorith.ClosestPointsAlgorithm;
import com.swissquant.assignment.numbersdistance.model.Point;

public class ClosestPointsBruteForce implements ClosestPointsAlgorithm {

	@Override
	public List<Point> getClosestPoints(Map<Integer, Point> pointUnivers, Point givenPoint, int resultSetSize) {		
		List<Point> universList = pointUnivers.values().stream().collect(Collectors.toList());
		
		final PriorityQueue<Point> kClosest = new PriorityQueue<Point>(resultSetSize, Collections.reverseOrder());
		
	    for (int i = 0; i < universList.size(); i++) {
	        if (kClosest.size() < resultSetSize) {
	        	kClosest.add(universList.get(i));
	        } else if (universList.get(i).getDist() < kClosest.peek().getDist()) {
	            kClosest.remove();
	            kClosest.add(universList.get(i));
	        }
	    }
	    
		return kClosest.stream().collect(Collectors.toList());
	}

}
