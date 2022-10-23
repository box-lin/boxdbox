package com.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class HuffmanTree {
	
	private Node root;

	public HuffmanTree(byte [] byteArray) {
		this.root = this.constructHuffmanTree(byteArray);
	}

	/**
	 * Construct the HuffMan tree by greedy, always pick the two minimum frequencies to construct a subtree.
	 * @param byteArray
	 * @return the root of the tree.
	 */
	private Node constructHuffmanTree(byte [] byteArray) {
		
		//Step 1. Track of byte frequency
		Map<Byte, Integer> freqTable = this.getByteFrequencies(byteArray);
		
		//Step 2. Initial Nodes and store them into a LinkedList.
		LinkedList<Node> nodeList = this.getNodeList(freqTable);
		
		//Step 3. Construct the tree
		while (nodeList.size() > 1) {
			// sort each time since we are adding new node into the nodeList
			Collections.sort(nodeList);
			Node leftNode = nodeList.poll();
			Node rightNode = nodeList.poll();
			Node parentNode = new Node(null, leftNode.frequency + rightNode.frequency);
			parentNode.left = leftNode;
			parentNode.right = rightNode;
			nodeList.add(parentNode);
		}
		
		return nodeList.poll();
	}
	
	/**
	 * 
	 * @param byteArray
	 * @return
	 */
    private Map<Byte, Integer> getByteFrequencies(byte [] byteArray){
		Map<Byte, Integer> freqTable = new HashMap<Byte, Integer>();
		for (byte by:byteArray) {
			Integer frequency = freqTable.getOrDefault(by, 0);
			frequency++;
			freqTable.put(by, frequency);
		}
		return freqTable;
	}
    
    /**
     * 
     * @param freqTable
     * @return
     */
	private LinkedList<Node> getNodeList(Map<Byte, Integer> freqTable){
		
		LinkedList<Node> nodeList = new LinkedList<Node>();
		// traverse through the huffmanTable
		for (Map.Entry<Byte, Integer> entry: freqTable.entrySet()) {
			Node curnode = new Node(entry.getKey(), entry.getValue());
			nodeList.add(curnode);
		}
		return nodeList; 
		
	}
	/**
	 * 
	 * @return Root Node
	 */
	public Node getRoot() {
		return this.root;
	}
	
	/**
	 * Just a debugging console print, to print the HuffMan Tree in pre-order.
	 */
	public void preorderPrint() {
		Node cur = this.root;
		dfs(cur);
	}
	
	private void dfs(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node);
		dfs(node.left);
		dfs(node.right);
	}
	
}
