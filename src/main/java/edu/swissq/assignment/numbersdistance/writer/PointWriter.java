package edu.swissq.assignment.numbersdistance.writer;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.inject.Named;

@Named
public class PointWriter {

	public void writeFile(byte[] pointUniverse, String fileName) {		
		try (FileOutputStream out = new FileOutputStream(fileName)) {
			out.write(pointUniverse);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
