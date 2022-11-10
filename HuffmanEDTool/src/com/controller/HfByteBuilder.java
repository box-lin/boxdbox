package com.controller;

import com.model.HuffmanTree;
import com.model.HuffmanTable;

public class HfByteBuilder {
	
	private byte [] hfByteArr; 
 
	
	public HfByteBuilder(byte [] byteArray) {
		this.hfByteArr = build(byteArray);		
	}
	

	/**
	 * HOW TO BUILD?
	 * Huffman Tree -> Huffman Table -> Huffman Bytes
	 * @param byteArray
	 * @return hfByteArray
	 */
	private byte[] build(byte[] byteArray) {
		HuffmanTree hfTree = new HuffmanTree(byteArray);
		HuffmanTable hfTable = new HuffmanTable(hfTree);
		
		//huffmanByte in string 
		StringBuilder sb = new StringBuilder();
		for (byte b: byteArray) {
			sb.append(hfTable.getHuffmanCodeTable().get(b));
		}
		
		//then we have to make it into byte, signed!
		int bytelen = (sb.length() % 8 == 0) ? (sb.length() / 8) : (sb.length() / 8 + 1);
		byte[] hfByteArr = new byte[bytelen];
		
		int idx = 0;
		for(int i = 0; i < sb.length(); i+=8) {
			String curstrByte = sb.substring(i, Math.min(sb.length(), i+8) );
			//to a signed byte
			hfByteArr[idx] = (byte)Integer.parseInt(curstrByte, 2);
			idx++;
		}
		return hfByteArr;
	}
	
	public byte[] getHuffmanBytese() {
		return this.hfByteArr;
	}
}
