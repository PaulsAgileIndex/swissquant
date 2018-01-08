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
	
	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		return 0;
	}	

}
