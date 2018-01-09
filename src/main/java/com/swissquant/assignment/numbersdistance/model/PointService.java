package com.swissquant.assignment.numbersdistance.model;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.swissquant.assignment.numbersdistance.algorithm.AlgoFactory;
import com.swissquant.assignment.numbersdistance.algorithm.ClosestPointsAlgorithm;
import com.swissquant.assignment.numbersdistance.algorithm.FurthestPointsAlgorithm;
import com.swissquant.assignment.numbersdistance.reader.PointReader;

/**
 * Service class to finding the closest/furthest points to a given point. 
 * 
 * @author Frank Sprich
 *
 */
@Service
public class PointService {
	
	@Inject
	private PointReader reader;
	
	
	/**
	 * Compute closest points to given Point and resultSetSize.
	 * 
	 * @param givenPoint Point provided
	 * @param resultSetSize result set size
	 * @return List of closest Points 
	 */
	public List<Point> findClosestPointsTo(Point givenPoint, int resultSetSize, String algoName) {	
		ClosestPointsAlgorithm algo = AlgoFactory.getClosestPointsAlgorithm(algoName);
		return algo.getClosestPoints(reader.getCachedPointsMap(), givenPoint, resultSetSize);
	}
	
	/**
	 * Compute furthest points to given Point and resultSetSize.
	 * 
	 * @param givenPoint Point provided
	 * @param resultSetSize result set size
	 * @return List of furthest Points 
	 */
	public List<Point> findFurthestPointsTo(Point givenPoint, int resultSetSize, String algoName) {
		FurthestPointsAlgorithm algo = AlgoFactory.getFurthestPointsAlgorithm(algoName);
		return algo.getFurthestPoints(reader.getCachedPointsMap(), givenPoint, resultSetSize);
	}

}
