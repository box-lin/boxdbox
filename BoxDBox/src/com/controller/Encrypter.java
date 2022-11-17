package com.controller;

import com.model.HuffmanCode;
import com.model.HuffmanTable;
import com.model.Packet;
import com.model.SecretPass;

/**
 * 
 * Encrypter is a class wrap things up.
 * 
 * - EnReader
 * - EnWriter
 * - Hasher
 * - HfByteBuilder
 * 
 * 
 * @author boxianglin
 *
 */
public class Encrypter {
	
 	//hasher for hashed SHA256
	private Hasher hasher;
	
	//hfByteBuilder contains hfCode and hfBytes
	private PacketBuilder pb;
	
	private EnReader fr;
	private EnWriter fo;
	
	/**
	 * An encrypter need a inputPath, outputPath, and a secretKey from user.
	 * @param inputPath
	 * @param outputPath
	 * @param secretKey
	 */
	public Encrypter(String inputPath, 
					 String outputPath, 
					 String secretKey){
		
		this.fr = new EnReader(inputPath);
		this.fo = new EnWriter(outputPath);
		this.hasher = new Hasher(secretKey);
		this.pb = new PacketBuilder(this.fr.readByteArr()); 		
	}
	
	/**
	 * box a input file and write a packet to the file.
	 */
	public void box() {		
		// pack the packet
		Packet packet = this.packThePacket();
		fo.writeFile(packet); 
	}
	
	
	/**
	 * packet SecretPass, HuffmanCode, HuffmanTable into a packet.
	 * @return packet
	 */
	private Packet packThePacket() {
		SecretPass secretPass = new SecretPass(this.hasher.getHashPassword());
		HuffmanCode hfCode = this.pb.getHuffmanCode();
		HuffmanTable hfTable = this.pb.getHuffmanTable();
		return new Packet(hfTable, hfCode, secretPass);
	}	
}



