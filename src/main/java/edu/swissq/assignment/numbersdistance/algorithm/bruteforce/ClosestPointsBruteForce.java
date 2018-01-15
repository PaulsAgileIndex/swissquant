package edu.swissq.assignment.numbersdistance.algorithm.bruteforce;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import edu.swissq.assignment.numbersdistance.algorithm.ClosestPointsAlgorithm;
import edu.swissq.assignment.numbersdistance.model.Point;

/**
 * Brute force implementation of type ClosestPointsAlgorithm.
 * 
 * @author Frank Sprich
 *
 */
public class ClosestPointsBruteForce implements ClosestPointsAlgorithm {

	@Override
	public List<Point> getClosestPoints(Map<Integer, Point> pointUnivers, Point givenPoint, int resultSetSize) {
		List<Point> universList = pointUnivers.values().stream().collect(Collectors.toList());

		final PriorityQueue<Point> resultClosest = new PriorityQueue<Point>(resultSetSize, Collections.reverseOrder());

		for (int i = 0; i < universList.size(); i++) {
			if (resultClosest.size() < resultSetSize) {
				resultClosest.add(universList.get(i));
			} else if (universList.get(i).getDist(givenPoint) < resultClosest.peek().getDist(givenPoint)) {
				resultClosest.remove();
				resultClosest.add(universList.get(i));
			}
		}

		return resultClosest.stream().collect(Collectors.toList());
	}



}
