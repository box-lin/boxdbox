package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.model.Node;

class NodeTest {

	@Test
	void testNodeToString() {
		Byte data = 1;
		Node node = new Node(data, 5);
		String expect = "Node {data=1, frequency=5}";
		assertEquals(node.toString(), expect);
	}

}
