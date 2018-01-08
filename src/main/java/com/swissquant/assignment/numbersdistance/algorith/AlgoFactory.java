package com.swissquant.assignment.numbersdistance.algorith;

import com.swissquant.assignment.numbersdistance.algorith.bruteforce.ClosestPointsBruteForce;
import com.swissquant.assignment.numbersdistance.algorith.bruteforce.FurthestPointsBruteForce;

public class AlgoFactory {
	
	private static final String BRUTE_FORCE = "bruteforce";
	private static ClosestPointsAlgorithm closestAlgo; 
	private static FurthestPointsAlgorithm furthestAlgo;
	
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
