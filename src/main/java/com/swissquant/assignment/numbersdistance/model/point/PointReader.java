package com.swissquant.assignment.numbersdistance.model.point;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Named;

import org.apache.commons.io.IOUtils;

/**
 * Read Points from file and provide reduced map as input data. 
 * 
 * @author Frank Sprich
 *
 */
@Named
public class PointReader {

	private static final String FILE_NAME = "points";
	private static final int DECODE_OFFSET = 4;
	private Point tempPoint;
	private short x;
	private short y;	
	private ConcurrentHashMap<Integer, Point> pointsCache;

	/**
	 * Read data from file only once during runtime.
	 * 
	 * @return ConcurrentHashMap all data from file
	 */
	public ConcurrentHashMap<Integer, Point> getCachedPointsMap() {
		if (null == pointsCache) {
			pointsCache = new ConcurrentHashMap<>();
		}

		if (pointsCache.isEmpty()) {
			readFile();
		}
		return pointsCache;
	}

	/**
	 * Read 16 bit coded file to byte array and decode to signed short.
	 */
	private void readFile() {	
		/* Read "points" file as resource */
		ClassLoader cl = Thread.currentThread().getContextClassLoader();	
		try(InputStream in = cl.getResourceAsStream(FILE_NAME)){
			byte[] bytes = IOUtils.toByteArray(in);

			for (int i = 0; i < bytes.length; i = i + DECODE_OFFSET) {
				/* Decode 16 bit to short coordinate */
				x = ByteBuffer.wrap(new byte[]{bytes[i], bytes[i+1]}).getShort();
				y = ByteBuffer.wrap(new byte[]{bytes[i+2], bytes[i+3]}).getShort();
				
				/* Create Point object and cache it */
				cacheReduce(x, y);				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create Point object and cache it. 
	 * Reduce number of possible input Point objects by creating a mathematical set (Map).
	 * 
	 * @param x coordinate of a Point
	 * @param y coordinate of a Point
	 */
	private void cacheReduce(short x, short y) {
		tempPoint = new Point(x, y);
		pointsCache.put(tempPoint.hashCode(), tempPoint);
	}

}
