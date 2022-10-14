package com.model;

public class Node implements Comparable<Node>{
	
	// byte data
	Byte data;
	
	// frequency of the data
	int frequency;
	
	Node left; 
	Node right;
	
	/**
	 * Constructor for a Node
	 * @param data
	 * @param frequency
	 */
	public Node(Byte data, int frequency) {
		this.data = data;
		this.frequency = frequency;
	}

	/**
	 * In order to construct HuffmanTree we need to compare the node
	 * with its frequency. By overrides the compareTo we can customize
	 * our compare method.
	 */
	@Override
	public int compareTo(Node o) {
		// increasing order
		return this.frequency - o.frequency;
	}
	
	/**
	 * A method to view the information of the node.
	 */
	@Override
	public String toString() {
		return null;
		
	}
}
