package com.model;

import java.io.Serializable;

/**
 * 
 * SecretPass contains a Stirng hashedPassword.
 * 
 * @author boxianglin
 *
 */
public class SecretPass implements Serializable{
	
	private String hashedPassword;
	
	
	public SecretPass(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	
	public String getMyHashedPassword() {
		return this.hashedPassword;
	}
	

	
	
}
