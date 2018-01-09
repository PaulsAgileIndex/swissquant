package com.swissquant.assignment.numbersdistance.algorithm.bruteforce;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.swissquant.assignment.numbersdistance.model.Point;

public class ClosestPointsBruteForceTest {
	
	private static Map<Integer, Point> pointUniverse;
	private static ClosestPointsBruteForce algorithm;
	private static List<Point> closerPoints;
	private static List<Point> furtherPoints;
	
	@BeforeClass
	public static void setUpOnce() {
		pointUniverse = new HashMap<>();
		closerPoints = new ArrayList<>();
		furtherPoints = new ArrayList<>();
		putPointToUniverseAndCloserList(1, 1);
		putPointToUniverseAndCloserList(2, 2);
		putPointToUniverseAndCloserList(3, 3);
		putPointToUniverseAndCloserList(4, 4);
		putPointToUniverseAndFurtherList(100, 100);
		putPointToUniverseAndFurtherList(200, 200);
		putPointToUniverseAndFurtherList(300, 300);
		putPointToUniverseAndFurtherList(400, 400);
		algorithm = new ClosestPointsBruteForce();
	}
	
	@Test
	public void testGetClosestPoints() {
		List<Point> resultList = algorithm.getClosestPoints(pointUniverse, new Point(7, 7), 4);
		assertThat(resultList).isNotNull().isNotEmpty().hasSize(4);
		for (Point closestPoint : closerPoints) {
			boolean match = false;
			for (Point resultPoint : resultList) {
				if(closestPoint.compareTo(resultPoint) == 0) {
					match = true;
				}
			}
			assertThat(match).isTrue();
		}
	}
	
	private static void putPointToUniverseAndCloserList(int x, int y) {
		Point point = new Point(x, y);
		closerPoints.add(point);
		putPointsToUniverse(point);
	}
	
	private static void putPointToUniverseAndFurtherList(int x, int y) {
		Point point = new Point(x, y);
		furtherPoints.add(point);
		putPointsToUniverse(point);		
	}
	
	private static void putPointsToUniverse(Point point) {
		pointUniverse.put(point.hashCode(), point);
	}

}
