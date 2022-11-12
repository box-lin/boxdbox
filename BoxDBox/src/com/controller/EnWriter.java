package com.controller;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import com.model.Packet;

/**
 * EnWriter gets a destPath and write the packet to file.
 * 
 * @author boxianglin
 *
 */
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
		}finally {
			try {
				os.close();
				oos.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
