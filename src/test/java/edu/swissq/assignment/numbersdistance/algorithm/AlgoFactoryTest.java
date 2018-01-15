package edu.swissq.assignment.numbersdistance.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import edu.swissq.assignment.numbersdistance.algorithm.bruteforce.ClosestPointsBruteForce;
import edu.swissq.assignment.numbersdistance.algorithm.bruteforce.FurthestPointsBruteForce;

public class AlgoFactoryTest {
	
	private static final String BRUTE_FORCE = "bruteforce";
	
	@Test
	public void testGetClosestPointsAlgorithm() {
		assertThat(AlgoFactory.getClosestPointsAlgorithm(BRUTE_FORCE)).isOfAnyClassIn(ClosestPointsBruteForce.class);
	}
	
	@Test
	public void testGetFurthestPointsAlgorithm() {
		assertThat(AlgoFactory.getFurthestPointsAlgorithm(BRUTE_FORCE)).isOfAnyClassIn(FurthestPointsBruteForce.class);
	}

}
