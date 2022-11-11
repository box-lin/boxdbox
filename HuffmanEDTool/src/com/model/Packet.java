package com.model;

import java.io.Serializable;

public class Packet implements Serializable{
	
	private HuffmanTable hmTable;
	private SecretPass sec;
	private HuffmanCode hmCode;
	
	public Packet(HuffmanTable hmTable, HuffmanCode hmCode, SecretPass sec) {
		this.hmTable = hmTable;
		this.hmCode = hmCode;
		this.sec = sec;
	}
	
	public HuffmanTable getHuffmanTable() {
		return this.hmTable;
	}
	
	public SecretPass getSecretPass() {
		return this.sec;
	}
	
	public HuffmanCode getHuffmanCode() {
		return this.hmCode;
	}
	
	
}
