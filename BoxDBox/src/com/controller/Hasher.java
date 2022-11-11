package com.controller;

import java.security.MessageDigest;

 
/**
 * 
 * @author boxianglin
 * 
 * Hasher wrapper utilize java.security package
 * This is SHA-256 hasher
 *
 */
public class Hasher {
	
	private byte[] passBytes;
	String algorithm = "SHA-256";
	
	
	public Hasher(String passString) {
		this.passBytes = passString.getBytes();
	}
	
	/**
	 * 
	 * 
	 * @return string representation for hex. If empty string, error can be found in printStackTrace.
	 */
	public String getHashPassword(){
		
		String hashedPassword = "";
		try {
			MessageDigest md = MessageDigest.getInstance(this.algorithm);
			byte[] digestedBytes = md.digest(this.passBytes);	
			
			//to hex string
			StringBuffer stringBuffer = new StringBuffer();
			String temp = null;
			for(int i = 0;i < digestedBytes.length; i++){
				// 0xff = 00000000000000000000000011111111
				temp = Integer.toHexString(digestedBytes[i] & 0xFF);
				if (temp.length()==1){
					stringBuffer.append("0");
				}
				stringBuffer.append(temp);
			}
			hashedPassword = stringBuffer.toString();
						
		}catch(Exception e) {
			e.printStackTrace();
		}
		return hashedPassword;
	}
}



