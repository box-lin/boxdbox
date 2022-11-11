package com.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model.HuffmanCode;
import com.model.HuffmanTable;

public class Decrypter {
	
	
	private byte[] oriByteArr;
 
	public Decrypter(byte[] byteArr, HuffmanTable hfTable, HuffmanCode hfcode) {
		this.oriByteArr = this.decrypt(byteArr, hfTable, hfcode);
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
	 *  SOLUTION: hfcode deserialized. 	
	 *  
	 *  
	 * @param byteArr
	 * @param hfTable
	 */
	public byte[] decrypt(byte[] byteArr, HuffmanTable hfTable, HuffmanCode hfcode) {
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
	
	public byte[] getOriByteArr() {
		return this.oriByteArr;
	}
	
	
 
}
