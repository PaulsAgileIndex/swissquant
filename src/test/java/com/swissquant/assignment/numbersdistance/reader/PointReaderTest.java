package com.swissquant.assignment.numbersdistance.reader;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.swissquant.assignment.numbersdistance.model.Point;

public class PointReaderTest {
	
	private static PointReader reader;
	private static Map<Integer, Point> resultMap;
	private static List<Point> specificPoints;
	
	@BeforeClass
	public static void setUpOnce() {
		reader = new PointReader("points-test");
		resultMap = reader.getCachedPointsMap();
		specificPoints = new ArrayList<>();
		
		/* Given points by the assignment to check correct decoding of input file */
		specificPoints.add(new Point(-715, 22165));
		specificPoints.add(new Point(761, -23591));
		specificPoints.add(new Point(-194, 6014));
	}
	
	@Test
	public void test() {
		assertThat(reader).isNotNull();
	}
	
	@Test
	public void testGetCachedPointsMap() {
		assertThat(resultMap).isNotNull().isNotEmpty();
	}
	
	@Test
	public void testExistanceOfSpecificPoints() {
		specificPoints.forEach(p -> {
				resultMap.get(p.hashCode());
				assertThat(resultMap.get(p.hashCode())).isNotNull();
			});
	}
	


}
