package com.swissquant.assignment.numbersdistance.algorithm;

import com.swissquant.assignment.numbersdistance.algorithm.bruteforce.ClosestPointsBruteForce;
import com.swissquant.assignment.numbersdistance.algorithm.bruteforce.FurthestPointsBruteForce;

/**
 * This factory decides based on the provided algoName which algorithm is used for computing the closest/furthest points.
 * 
 * @author Frank Sprich
 *
 */
public class AlgoFactory {
	
	private static final String BRUTE_FORCE = "bruteforce";
	private static ClosestPointsAlgorithm closestAlgo; 
	private static FurthestPointsAlgorithm furthestAlgo;
	
	/**
	 * Factory method for ClosestPointsAlgorithm algorithm.
	 * 
	 * @param algoName name of the algorithm
	 * @return a ClosestPointsAlgorithm algorithm
	 */
	public static ClosestPointsAlgorithm getClosestPointsAlgorithm(String algoName) {
		switch (algoName) {
		case BRUTE_FORCE:
			closestAlgo = new ClosestPointsBruteForce();
			break;
		default:
			closestAlgo = new ClosestPointsBruteForce();
			break;
		}		
		return closestAlgo;
	}
	
	/**
	 * Factory method for FurthestPointsAlgorithm algorithm.
	 * 
	 * @param algoName name of the algorithm
	 * @return a FurthestPointsAlgorithm algorithm
	 */
	public static FurthestPointsAlgorithm getFurthestPointsAlgorithm(String algoName) {
		switch (algoName) {
		case BRUTE_FORCE:
			furthestAlgo = new FurthestPointsBruteForce();
			break;
		default:
			furthestAlgo = new FurthestPointsBruteForce();
			break;
		}		
		return furthestAlgo;
	}


}
