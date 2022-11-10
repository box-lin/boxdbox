package com.controller;

import java.util.Base64;

import com.model.HuffmanTable;

public class Decrypter {
	
	/**
	 * 
	 * How to decrypt?
	 * 
	 * When we get the HuffmanBytes
	 * We have to convert it to String
	 * 
	 * BUT! The bytes is signed
	 * 
	 * We can't just simply convert it.
	 * 
	 * 
	 * 
	 */
	public Decrypter(byte[] byteArr, HuffmanTable hfTable) {
		this.decrypt(byteArr, hfTable);
	}
	
	/**
	 * [BE CARFUL]
	 * 
	 *  String sbyte = "011";
     *  byte b = (byte)Integer.parseInt(sbyte, 2);
     *  int binary = b;
     *  String snew = Integer.toBinaryString(binary);
     *  System.out.println(snew);
	 *  >> "11"  
	 *  
	 *  1. byte is signed. A positive byte convert to a string lose its prefix 0s.
	 *  2. A negative byte convert to a string turns out to be a length of 32 filled with prefix 1s.
	 *  
	 *  WHAT TO DO?
	 *  Suppose given a byte[] B with length N 
	 *  for i in [0, N-2] we got 2 cases to consider 
	 *  	1. B[i] is negative, we want have to get the substring of 8 least significant bits 
	 *  	2. B[i] is positive, we have to filled the prefix 0 up to length 8 
	 *  
	 *  WARNING!
	 *  for B[N-1], meaning the last byte, is not necessary to be a length of 8 originally.
	 *  why? please refer HfByteBuilder.java line 39
	 *  
	 *  That said, length of B[N-1] <= 8, two possibilities, length equals to 8 or less than 8
	 *  Suppose length is equal to 8, similar to above logic:
	 *  	If B[N-1] is positive, we have to filled the prefix 0 up to length 8
	 *  	If B[N-1] is negative, we want have to get the substring of 8 least significant bits 
	 * 	
	 *  Now, suppose length is less than 8 
	 *  	ONLY CASE AND ONLY POSITIVE: 1011b=11d, 010b=2d --> ALL POSITIVE
	 *  	BUT continuous prefix of 0 will be ignored, 0001 to 1, 00001 to 1 000001 to 1.
	 *  	So ended up with two cases:
	 *  		1. if prefix starts with 1, all good no need to do anything
	 *  		2. if prefix starts with 0, how to know how many 0s need to be recover???	
	 *  
	 *  
	 * @param byteArr
	 * @param hfTable
	 */
	public void decrypt(byte[] byteArr, HuffmanTable hfTable) {
		
		StringBuilder sb = new StringBuilder();
		for (byte b : byteArr) {
			int binary = b;
			
			// 1) edge case:  OR with all 1 0000 0000 
			//    handles positive number to length > 8 after converted to string
			binary |= 256;
			String byteStr = Integer.toBinaryString(binary);
			
			// 2) edge case: please refer HfByteBuilder.java line 39
			//    there exists a case where the string is not length 8 when we convert to HuffmanByte
			byteStr = byteStr.substring(byteStr.length() - 8);
			System.out.println(byteStr);
 
		}
		System.out.println("Inverted code " + sb.toString());
		
	}
	
	
 
}
