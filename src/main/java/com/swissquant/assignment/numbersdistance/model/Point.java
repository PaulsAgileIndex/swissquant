package com.swissquant.assignment.numbersdistance.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Point implements Comparable<Point> {
	
	private int x;
	private int y;
	
	public double getDist(){
    	return x*x+y*y;
    }
	
	@Override
	public int compareTo(Point o) {
		int c = Double.compare(getDist(), o.getDist());
		if(c == 0){
			c = Double.compare(x, o.x);
			if(c == 0){
				c = Double.compare(y, o.y);
			}
		}
		
		return c;
	}	

}
