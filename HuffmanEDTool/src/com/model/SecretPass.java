package com.model;

import java.io.Serializable;
import java.security.*;

public class SecretPass implements Serializable{
	
	
	public String pass = "abd";
	
	
	private String password;
	
	
	public SecretPass(String password) {
		this.password = password;
	}
	
	public String getMyHashedPassword() {
		return this.password;
	}
	

	
	
}
