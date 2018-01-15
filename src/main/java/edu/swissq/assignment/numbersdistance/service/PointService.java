package edu.swissq.assignment.numbersdistance.service;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.stereotype.Service;

import edu.swissq.assignment.numbersdistance.algorithm.AlgoFactory;
import edu.swissq.assignment.numbersdistance.algorithm.ClosestPointsAlgorithm;
import edu.swissq.assignment.numbersdistance.algorithm.FurthestPointsAlgorithm;
import edu.swissq.assignment.numbersdistance.model.Point;
import edu.swissq.assignment.numbersdistance.reader.PointReader;
import edu.swissq.assignment.numbersdistance.writer.PointWriter;

/**
 * Service class to finding the closest/furthest points to a given point. 
 * 
 * @author Frank Sprich
 *
 */
@Service
public class PointService {

	private PointReader reader;		
	private PointWriter writer;
	
	@Inject
	public PointService(PointReader reader, PointWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	
	private Random random = new Random();
	
	private static List<Point> basePoint = new ArrayList<>(Arrays.asList(new Point(-715, 22165), new Point(761, -23591), new Point(-194, 6015)));

	
	
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
	
	/**
	 * Create and Write the point unverse file.
	 * 
	 * @param size amount of the points in the universe
	 */
	public void createPointUniverse(int size, String fileName) {
		byte[] ininitalCoordinates = createIninitalCoordinates();
		writer.writeFile(fillPointUniverse(ininitalCoordinates, size), fileName);
	}
	
	private byte[] createIninitalCoordinates() {
		byte[] initialPointUniverse = new byte[0];
		
		for (Point point : basePoint) {
			initialPointUniverse = ArrayUtils.addAll(initialPointUniverse, encodeCoordinate(point.getX()));
			initialPointUniverse = ArrayUtils.addAll(initialPointUniverse, encodeCoordinate(point.getY()));
		}
		return initialPointUniverse;
	}

	
	private byte[] fillPointUniverse(byte[] initialPointCoordinates, int size) {
		List<byte[]> tempCoordinatesList = new ArrayList<>();
		
		/* One point has two coordinates -> times 2 */
		int remainingSize = size - (basePoint.size() * 2);	
		
		/* Create random coordinates */
		List<Short> randomCoordinates = createRandomCoordinates(remainingSize);
		
		/* Create byte[] for a coordinate */
		randomCoordinates.forEach(p -> {
			tempCoordinatesList.add(encodeCoordinate(p));
		});
		
		/* Add initial coordinates to point universe */
		List<Byte> coordinatesAsByteList = new ArrayList<>();
		for (int i = 0; i < initialPointCoordinates.length; i++) {
			coordinatesAsByteList.add(initialPointCoordinates[i]);
		}		
		
		/* Add random coordinates to point universe */
		for(byte[] tempArray : tempCoordinatesList) {
			for (int i = 0; i < tempArray.length; i++) {
				coordinatesAsByteList.add(tempArray[i]);
			}
		}

		/* Convert form List<Byte> to Byte[] */
		Byte[] tempPointUniverse = coordinatesAsByteList.toArray(new Byte[coordinatesAsByteList.size()]);		
		
		/* Convert from Byte[] to byte[] */
		byte[] pointUnivese = new byte[coordinatesAsByteList.size()];		
		int j = 0;
		for (Byte tempCoordinate : tempPointUniverse) {
			pointUnivese[j++] = tempCoordinate.byteValue();
		}

		return pointUnivese;
	}	
	
	/**
	 * 16 bit encoded integer value to byte[].
	 * 
	 * @param coordinate
	 * @return
	 */
	private byte[] encodeCoordinate(int coordinate) {
		return ByteBuffer.allocate(2).putShort((short)coordinate).array();
	}
	
	/**
	 * Create random coordinates for points in the point universe.
	 * 
	 * @param remainingSize
	 * @return
	 */
	private List<Short> createRandomCoordinates(int remainingSize) {
		List<Short> randomCoordinates = new ArrayList<>();
		
		for (int i = 0; i < remainingSize; i++) {
			Short randomShort = (short) (random.nextInt(Short.MAX_VALUE - Short.MIN_VALUE + 1)  + Short.MIN_VALUE);
			randomCoordinates.add(randomShort);
		}
		
		return randomCoordinates;
	}


}
