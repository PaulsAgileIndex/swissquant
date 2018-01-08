package com.swissquant.assignment.numbersdistance.algorith.bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.swissquant.assignment.numbersdistance.algorith.FurthestPoints;
import com.swissquant.assignment.numbersdistance.model.Point;

public class FurthestPointsBruteForce implements FurthestPoints {

	@Override
	public List<Point> getFurthestPoints(Map<Integer, Point> pointUnivers, Point givenPoint, int resultSetSize) {
		List<Point> universList = pointUnivers.values().stream().collect(Collectors.toList());
		
		List<Point> result = new ArrayList<>();
		return result;
	}

}
