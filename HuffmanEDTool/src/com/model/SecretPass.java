package com.model;

import java.io.Serializable;

public class SecretPass implements Serializable{
	
	
	public String pass = "abd";
	
	
	private String hashedPassword;
	
	
	public SecretPass(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	
	public String getMyHashedPassword() {
		return this.hashedPassword;
	}
	

	
	
}
