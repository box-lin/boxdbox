package com.controller;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import com.model.Packet;

public class EnWriter {
	
	private String destPath;

	public EnWriter(String destPath) {
		this.destPath = destPath;
	 
	}
	
	// write 
	public void writeFile(Packet packet) {
		OutputStream os = null;
		ObjectOutputStream oos = null;
		try {
			os = new FileOutputStream(this.destPath);
			oos = new ObjectOutputStream(os);
			oos.writeObject(packet);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
