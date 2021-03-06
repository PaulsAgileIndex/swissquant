package edu.swissq.assignment.numbersdistance.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Depicts a point in a 2D scale.
 * 
 * @author Frank Sprich
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Point implements Comparable<Point> {

	/** Coordinate on the x-axis */
	private int x;

	/** Coordinate on the y-axis */
	private int y;

//	/**
//	 * You can avoid computing Math.sqrt(dx*dx + dy*dy);. 
//	 * dx*dx + dy*dy is enough to compare the distances.
//	 * 
//	 * @return
//	 */
//	public double getDist() {
//		return x * x + y * y;
//	}

    /**
     * Returns the distance from this Point to specified Point.
     *
     * from java.awt.geom.Point2D
     */
    public double getDist(Point pt) {
        double px = pt.getX() - this.getX();
        double py = pt.getY() - this.getY();
        return Math.sqrt(px * px + py * py);
    }
	
	@Override
	public int compareTo(Point o) {
		int c = Double.compare(getDist(this), o.getDist(o));
		if (c == 0) {
			c = Double.compare(x, o.x);
			if (c == 0) {
				c = Double.compare(y, o.y);
			}
		}

		return c;
	}

}
