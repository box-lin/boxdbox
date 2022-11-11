package com.controller;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class DeWriter {
	
	private String outputPath;
	
	public DeWriter(String outputPath) {
		this.outputPath = outputPath;
	}
	
	public void writeFile(byte[] oriByteArr) {
		OutputStream os = null;
		try {
			os = new FileOutputStream(this.outputPath);
			os.write(oriByteArr);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				os.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
