package com.controller;

import com.model.Packet;

/**
 * Encrypter should receive secretKey and a input file path
 * 
 * 1. pack the SHA256 hashed secretkey and generate a huffman coding into a packet 
 * 2. serializing the packet into a output file
 * 
 * 
 * @author boxianglin
 *
 */
public class Encrypter {
	
	private Packet packet;
	private Hasher hasher;
	private HfByteBuilder hfByteBuilder;
	
	/**
	 * 
	 * @param secretKey
	 * @param filePath
	 */
	public Encrypter(String secretKey, String inputPath) {
		
		this.hasher = new Hasher(secretKey);
		this.hfByteBuilder = new HfByteBuilder(inputPath);
		this.buildPacket();
		
	}
	
	private void buildPacket() {
		
	}
	
	/**
	 * 
	 * Where to Serializing 
	 * @param outputPath
	 */
	public void serializing(String outputPath) {
		
	}
	
	
}



