package com.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HuffmanTree {
	
 
	private Node root;
	private Map<Byte, Integer> huffmanTable;
	
	public HuffmanTree(byte [] byteArray) {
		this.huffmanTable = this.getByteFrequencies(byteArray);
		this.root = this.constructHuffmanTree();
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

	private Node constructHuffmanTree() {
		
		LinkedList<Node> nodeList = this.getNodeList();
		
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
	 * @return a LinkedList with Nodes
	 */
	public LinkedList<Node> getNodeList(){
		
		LinkedList<Node> nodeList = new LinkedList<Node>();
		// traverse through the huffmanTable
		for (Map.Entry<Byte, Integer> entry: this.huffmanTable.entrySet()) {
			Node curnode = new Node(entry.getKey(), entry.getValue());
			nodeList.add(curnode);
		}
		return nodeList;
		
	}
	
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
