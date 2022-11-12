package com.controller;

import java.io.FileInputStream;

/**
 * 
 * EnReader gets inputPath and read the bytes from file.
 * 
 * @author boxianglin
 *
 */
public class EnReader {
	
	private String inputPath;
	
	public EnReader(String inputPath) {
		
		this.inputPath = inputPath;
	}
	
	public byte[] readByteArr() {
		FileInputStream is = null;
		byte[] content = null;
		try {
			is = new FileInputStream(this.inputPath);
			content = new byte[ is.available() ];
			is.read(content);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			try {
				is.close();	
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		return content;
	}
}
