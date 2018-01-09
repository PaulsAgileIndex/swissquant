package com.swissquant.assignment.numbersdistance.algorithm;

import java.util.List;
import java.util.Map;

import com.swissquant.assignment.numbersdistance.model.Point;

public interface ClosestPointsAlgorithm {
	
	/**
	 * Compute the closests points.
	 * 
	 * @param pointUnivers all the Points to be seached in
	 * @param givenPoint the point for which the closests points from the pointUnivers should be found
	 * @param resultSetSize the size of the result set
	 * @return the result set
	 */
	public abstract List<Point> getClosestPoints(Map<Integer, Point> pointUnivers, Point givenPoint, int resultSetSize);

}
