package com.model;

import java.io.Serializable;

public class Packet implements Serializable{
	
	HuffmanTable hmTable;
	SecretPass sec;
	
	public Packet(HuffmanTable hmTable, SecretPass sec) {
		this.hmTable = hmTable;
		this.sec = sec;
	}
	
	public HuffmanTable getTable() {
		return this.hmTable;
	}
	
	public SecretPass getSec() {
		return this.sec;
	}
}
