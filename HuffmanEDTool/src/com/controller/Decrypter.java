package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model.HuffmanCode;
import com.model.HuffmanTable;
import com.model.Packet;

/**
 * 
 * Decrypter unBox the .box file.
 * 
 * we deserialize the Packet from .box file.
 * packet = {HuffmanTable, HuffmanCode, SecretPass}
 * 
 * 
 * Validation Process: 
 * 1. we must first validates packet is valid or not, 
 * 	  if packet is not null that means this is a encrypted
 *    file, since we can pull packet out from it.
 * 
 * 2. we then verify the password that user entered, through 
 *    hashed(password) with SecrePass hashedPassword.
 *    
 * Decryption Process:
 * 1. we replace the key:val pair of original HuffmanTable
 * 2. we greedy iterate through HuffmanCode to find substr
 *    that are in revHuffmanTable keys() using 2 pointers 
 *    approach. 
 * 
 * 
 * @author boxianglin
 * @copyright @2022 
 */
public class Decrypter {
	
	private DeReader fr;
	private DeWriter fw;
	private String pass;

	
	public Decrypter(String inputPath, String outputPath, String pass) {
		this.fr = new DeReader(inputPath);
		this.fw = new DeWriter(outputPath);
		this.pass = pass;
		
	}
	
	/**
	 * unBox decrypts the file  
	 * @return
	 */
	public boolean unBox() {
		Packet packet = fr.readPacket();
		if (!this.validation(packet)) {
			return false;
		}
		
		HuffmanCode hfcode = packet.getHuffmanCode();
		HuffmanTable hfTable = packet.getHuffmanTable();
		

		byte[] oriByteArr = decrypt(hfTable, hfcode);
		fw.writeFile(oriByteArr);
		
		return true;
	}
	
	/**
	 * validation valid the encrypted file and password.
	 * @param packet
	 * @return is valid or not valid
	 */
	private boolean validation(Packet packet) {
		if (packet == null) return false;
		String hashedPass = packet.getSecretPass().getMyHashedPassword();
		return new Hasher(this.pass).getHashPassword().equals(hashedPass);
	}
	
	
	/**
	 * decrypt uses hfTable and hfcode to retreive the original byte array.
	 * @param hfTable
	 * @param hfcode
	 * @return original byte array.
	 */
	private byte[] decrypt(HuffmanTable hfTable, HuffmanCode hfcode) {
		// reverse hfTable
		Map<String, Byte> revHuffmanTable = new HashMap<String, Byte>();
		for(Map.Entry<Byte, String> entry: hfTable.getHuffmanCodeTable().entrySet()  ){
			revHuffmanTable.put(entry.getValue(), entry.getKey());
		}
		
		// 2 pointers scan 
		List<Byte> oriByteList = new ArrayList<Byte>();
		String hfcodestr = hfcode.getHuffmanCode();
		int n = hfcodestr.length();
		int l = 0;
		for(int r=0; r<n+1; r++) {
			String substr = hfcodestr.substring(l, r);
			if (revHuffmanTable.containsKey(substr)){
				oriByteList.add( revHuffmanTable.get(substr) );
				l = r;
			}
		}
		
		byte[] oriByteArr = new byte[ oriByteList.size()];
		for (int i=0; i < oriByteArr.length; i++) {
			oriByteArr[i] = oriByteList.get(i);
		}
		return oriByteArr;	
	}
	 
	 
}
