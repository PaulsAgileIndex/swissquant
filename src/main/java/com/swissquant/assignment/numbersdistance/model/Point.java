package com.swissquant.assignment.numbersdistance.model;

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

	/**
	 * You can avoid computing Math.sqrt(dx*dx + dy*dy);. 
	 * dx*dx + dy*dy is enough to compare the distances.
	 * 
	 * @return
	 */
	public double getDist() {
		return x * x + y * y;
	}

    /**
     * Returns the distance from this <code>Point2D</code> to a
     * specified <code>Point2D</code>.
     *
     * @param pt the specified point to be measured
     *           against this <code>Point2D</code>
     * @return the distance between this <code>Point2D</code> and
     * the specified <code>Point2D</code>.
     * @since 1.2
     */
    public double distance(Point pt) {
        double px = pt.getX() - this.getX();
        double py = pt.getY() - this.getY();
        return Math.sqrt(px * px + py * py);
    }
	
	@Override
	public int compareTo(Point o) {
		int c = Double.compare(getDist(), o.getDist());
		if (c == 0) {
			c = Double.compare(x, o.x);
			if (c == 0) {
				c = Double.compare(y, o.y);
			}
		}

		return c;
	}

}
