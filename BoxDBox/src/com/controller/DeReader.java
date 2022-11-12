package com.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

import com.model.Packet;

/**
 * DeReader get an inputPath and read its packet, if any!
 * 
 * @author boxianglin
 *
 */
public class DeReader {
	
	private String inputPath;
	
	public DeReader(String inputPath) {
		this.inputPath = inputPath;
	}
	
	// should return a packet
	public Packet readPacket() {
		InputStream is = null;
		ObjectInputStream ois = null;
		Packet packet = null;
		
		try {
			is = new FileInputStream(this.inputPath);
			ois = new ObjectInputStream(is);
			packet = (Packet)ois.readObject();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				is.close();
				ois.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return packet; //might be null if the file read did not encrypted by this software before.
	}

}
