package com.test;

import com.model.HuffmanTree;
import com.model.Node;

public class Demo {

	public static void main(String[] args) {
		Byte data = 1;
		Node node = new Node(data, 5);
//		System.out.println(node.toString());
		
		
		String content = "i like like like java do you like a java";
		byte [] bytes = content.getBytes();
		
		HuffmanTree tree = new HuffmanTree(bytes);
//		System.out.println(tree.getNodeList());
		tree.preorderPrint();
		
	}
	

}
