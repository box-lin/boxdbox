package com.controller;

import com.model.HuffmanTree;
import com.model.HuffmanCode;
import com.model.HuffmanTable;

public class HfByteBuilder {
	
	private byte [] hfByteArr; 
	private HuffmanCode hfcode;
	private HuffmanTable hfTable;
 
	
	public HfByteBuilder(byte [] byteArray) {
		this.hfByteArr = build(byteArray);		
	}
	

	/**
	 * HOW TO BUILD?
	 * Huffman Tree -> Huffman Table -> Huffman Code -> Huffman Bytes
	 * @param byteArray
	 * @return hfByteArray
	 */
	private byte[] build(byte[] byteArray) {
		HuffmanTree hfTree = new HuffmanTree(byteArray);
		this.hfTable = new HuffmanTable(hfTree);
		this.hfcode = new HuffmanCode(hfTable, byteArray);
		
		//then we have to make it into byte, signed!
		String huffmancodeStr = hfcode.getHuffmanCode();
		int n = huffmancodeStr.length();
		int bytelen = (n % 8 == 0) ? (n / 8) : (n / 8 + 1);
		byte[] hfByteArr = new byte[bytelen];
		
		int idx = 0;
		for(int i = 0; i < n; i+=8) {
			String curstrByte = huffmancodeStr.substring(i, Math.min(huffmancodeStr.length(), i+8) );
			//to a signed byte
			hfByteArr[idx] = (byte)Integer.parseInt(curstrByte, 2);
			idx++;
		}
		return hfByteArr;
	}
	
	public byte[] getHuffmanBytes() {
		return this.hfByteArr;
	}
	
	public HuffmanTable getHuffmanTable() {
		return this.hfTable;
	}
	
	public HuffmanCode getHuffmanCode() {
		return this.hfcode;
	}
}
