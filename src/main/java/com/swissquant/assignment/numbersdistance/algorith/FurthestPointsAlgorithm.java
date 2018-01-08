package com.swissquant.assignment.numbersdistance.algorith;

import java.util.List;
import java.util.Map;

import com.swissquant.assignment.numbersdistance.model.Point;

public interface FurthestPointsAlgorithm {

	public abstract List<Point> getFurthestPoints(Map<Integer, Point> pointUnivers, Point givenPoint, int resultSetSize);
	
}
