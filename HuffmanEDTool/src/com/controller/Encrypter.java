package com.controller;

import com.model.HuffmanCode;
import com.model.HuffmanTable;
import com.model.Packet;
import com.model.SecretPass;

/**
 * 
 * @author boxianglin
 *
 */
public class Encrypter {
	
 	//hasher for hashed SHA256
	private Hasher hasher;
	
	//hfByteBuilder contains hfCode and hfBytes
	private HfByteBuilder hfByteBuilder;
	
	private EnReader fr;
	private EnWriter fo;
	
	/**
	 * 
	 * @param secretKey
	 * @param filePath
	 */
	public Encrypter(String inputPath, 
					 String outputPath, 
					 String secretKey
					 ) {
		
		this.fr = new EnReader(inputPath);
		this.fo = new EnWriter(inputPath);
		this.hasher = new Hasher(secretKey);
		this.hfByteBuilder = new HfByteBuilder(this.fr.readByteArr()); 		
	}
	
	/**
	 * 
	 */
	public void zip() {		
		// pack the packet
		Packet packet = this.packThePacket();
		fo.writeFile(packet); 
	}
	
	private Packet packThePacket() {
		SecretPass secretPass = new SecretPass(this.hasher.getHashPassword());
		HuffmanCode hfCode = this.hfByteBuilder.getHuffmanCode();
		HuffmanTable hfTable = this.hfByteBuilder.getHuffmanTable();
		return new Packet(hfTable, hfCode, secretPass);
	}	
}



