package com.swissquant.assignment.numbersdistance.algorithm;

import java.util.List;
import java.util.Map;

import com.swissquant.assignment.numbersdistance.model.Point;

public interface FurthestPointsAlgorithm {

	/**
	 * Compute the furthest points.
	 * 
	 * @param pointUnivers all the Points to be seached in
	 * @param givenPoint the point for which the furthests points from the pointUnivers should be found
	 * @param resultSetSize the size of the result set
	 * @return the result set
	 */
	public abstract List<Point> getFurthestPoints(Map<Integer, Point> pointUnivers, Point givenPoint, int resultSetSize);
	
}
