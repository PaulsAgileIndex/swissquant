package edu.swissq.assignment.numbersdistance.reader;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.MessageFormat;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import edu.swissq.assignment.numbersdistance.model.Point;

/**
 * Read Points from file and provide reduced map as input data. 
 * 
 * @author Frank Sprich
 *
 */
@Named
public class PointReader {

	private Logger LOG = Logger.getLogger(PointReader.class);
	
	private String fileName = "myPointsUniverse";
	private static final int DECODE_OFFSET = 4;
	private Point tempPoint;
	private short x;
	private short y;	
	private ConcurrentHashMap<Integer, Point> pointsCache;

	/**
	 * Default constructor.
	 */
	public PointReader() {

	}
	
	/**
	 * Constructor: File name could be set from outside.
	 * 
	 * @param fileName from outside
	 */
	public PointReader(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * Reading given (static) file "points" at application start time.
	 * 
	 * NOTE:
	 * The given assignment does not require reading different input files.
	 * Could be changed in later iterations.
	 */
	@PostConstruct
	public void init() {
		getCachedPointsMap();
	}
	
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
		try(InputStream in = cl.getResourceAsStream(fileName)){
			byte[] bytes = IOUtils.toByteArray(in);
			long start = System.currentTimeMillis();
			for (int i = 0; i < bytes.length; i = i + DECODE_OFFSET) {
				/* Decode 16 bit to short coordinate */
				x = ByteBuffer.wrap(new byte[]{bytes[i], bytes[i+1]}).getShort();
				y = ByteBuffer.wrap(new byte[]{bytes[i+2], bytes[i+3]}).getShort();
				
				/* Create Point object and cache it */
				cacheReduce(x, y);					
			}
			long duration = (System.currentTimeMillis() - start) / 1000;
			LOG.info(MessageFormat.format("Duration {0} sec. for computing cached input map of {1} Point elements", duration, pointsCache.size()));
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
