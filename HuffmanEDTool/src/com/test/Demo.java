package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Base64;

import com.model.HuffmanCode;
import com.model.HuffmanTable;
import com.model.HuffmanTree;
import com.model.Node;
import com.model.Packet;
import com.model.SecretPass;
import com.controller.Decrypter;
import com.controller.Encrypter;
import com.controller.Hasher;
import com.controller.HfByteBuilder;

public class Demo {

	public static void main(String[] args) throws Exception {
		TestEncrypter();
//		TestHfByteBuilder();
//		TetDecrypter();
//		Byte data = 1;
//		Node node = new Node(data, 5);
////		System.out.println(node.toString());
//		
////		
//		String content = "i like like like java do you like a java";
//		byte [] bytes = content.getBytes();
//		System.out.println(Arrays.toString(bytes));
//		HuffmanTree tree = new HuffmanTree(bytes);
//		HuffmanTable table = new HuffmanTable(tree);
//		
//		
//		HfByteBuilder hb = new HfByteBuilder(bytes);
//		byte [] newbytes = hb.getHuffmanBytes();
//		System.out.println(Arrays.toString(hb.getHuffmanBytes()));
//		
//		Decrypter d = new Decrypter(newbytes, table);

//        String sbyte = "00010";
//        byte b = (byte)Integer.parseInt(sbyte, 2);
//        int binary = b;
//        System.out.println(binary);
//        String snew = Integer.toBinaryString(binary);
//        System.out.println(snew);
////	

//		HuffmanTree tree = new HuffmanTree(bytes);
////		System.out.println(tree.getNodeList());
////		tree.preorderPrint();
//		
//		HuffmanTable table = new HuffmanTable(tree);
//		table.printTable();
		
//		TestObjectStream();
//		readObject();
//		Hasher hasher = new Hasher("abc123");
//		System.out.println(hasher.getHashPassword());
//		Hasher hasher2 = new Hasher("abc123");
//		System.out.println(hasher2.getHashPassword());
	}
	
	public static void TestEncrypter() {
		Encrypter en = new Encrypter("like.txt", "like.box", "123");
		en.box();
	}
	
	public static void TetDecrypter() {
		String content = "i like like like java do you like a java";
		byte [] bytes = content.getBytes();
		System.out.println(Arrays.toString(bytes));
		
		HfByteBuilder hb = new HfByteBuilder(bytes);
		byte [] newbytes = hb.getHuffmanBytes();
		 
		
		
		HuffmanTree hfTree = new HuffmanTree(bytes);
		HuffmanTable hfTable = new HuffmanTable(hfTree);
		HuffmanCode hfcode = new HuffmanCode(hfTable, bytes);
		
		Decrypter d = new Decrypter(hfTable, hfcode);
		System.out.println(Arrays.toString(d.getOriByteArr()));
		String orstr = new String(d.getOriByteArr());
		System.out.println(orstr);
	}
	
	
	
	public static void TestHfByteBuilder() {
		String content = "i like like like java do you like a java";
		byte [] bytes = content.getBytes();
		HfByteBuilder hb = new HfByteBuilder(bytes);
		byte [] newbytes = hb.getHuffmanBytes();
		System.out.println(Arrays.toString(hb.getHuffmanBytes()));
	}
	
	
	public static void TestObjectStream() throws IOException {
		String content = "i like like like java do you like a java";
		byte [] bytes = content.getBytes();
		HuffmanTree tree = new HuffmanTree(bytes);
		HuffmanTable table = new HuffmanTable(tree);
		
		table.printTable();
		
//		SecretPass s = new SecretPass();
//		Packet p = new Packet(table,s);
//		writeObj(p);
//		
	}
	
	public static void writeObj(Packet p) throws IOException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test1.txt"));
		oos.writeObject(p);
		oos.close();
	}
	
//	public static void readObject() throws IOException, IOException, ClassNotFoundException {
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test1.txt"));
//		Packet obj = (Packet)ois.readObject();
//		HuffmanTable tb = obj.getTable();
//		SecretPass s = obj.getSec();
//		tb.printTable();
//		System.out.println(s.pass);
//		ois.close();
//	}
	

}
