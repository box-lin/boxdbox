package com.model;

import java.io.Serializable;

/**
 * HuffmanCode is translated from HuffmanTable
 * 
 * @author boxianglin
 *
 */
public class HuffmanCode implements Serializable {
	
	private String huffmanCode;
	
	public HuffmanCode(HuffmanTable hmTable, byte[] byteArr) {
		this.huffmanCode = getHuffmanCode(hmTable, byteArr);
	}
	
	private String getHuffmanCode(HuffmanTable hmTable, byte[] byteArr) {
		HuffmanTree hfTree = new HuffmanTree(byteArr);
		HuffmanTable hfTable = new HuffmanTable(hfTree);
		
		//huffmanByte in string 
		StringBuilder sb = new StringBuilder();
		for (byte b: byteArr) {
			sb.append(hfTable.getHuffmanCodeTable().get(b));
		}

		return sb.toString();
	}
	
	public String getHuffmanCode() {
		return this.huffmanCode;
	}	

}
