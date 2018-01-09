package com.swissquant.assignment.numbersdistance.algorithm.bruteforce;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import com.swissquant.assignment.numbersdistance.algorithm.FurthestPointsAlgorithm;
import com.swissquant.assignment.numbersdistance.model.Point;

/**
 * Brute force implementation of type FurthestPointsAlgorithm
 * 
 * @author Frank Sprich
 *
 */
public class FurthestPointsBruteForce implements FurthestPointsAlgorithm {

	@Override
	public List<Point> getFurthestPoints(Map<Integer, Point> pointUnivers, Point givenPoint, int resultSetSize) {
		List<Point> universList = pointUnivers.values().stream().collect(Collectors.toList());

		final PriorityQueue<Point> resultFurthest = new PriorityQueue<Point>(resultSetSize);

		for (int i = 0; i < universList.size(); i++) {
			if (resultFurthest.size() < resultSetSize) {
				resultFurthest.add(universList.get(i));
			} else if (universList.get(i).getDist() > resultFurthest.peek().getDist()) {
				resultFurthest.remove();
				resultFurthest.add(universList.get(i));
			}
		}

		return resultFurthest.stream().collect(Collectors.toList());
	}

}
