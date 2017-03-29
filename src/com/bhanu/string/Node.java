package com.bhanu.string;

import java.util.HashMap;
import java.util.Map;

public class Node {

	Map<Character , Node> node;
	boolean isEnd;
	
	public Node(){
		node = new HashMap<Character , Node>();
		isEnd = false;
	}
	
	public Node(Character c  , Node node){
		this.node.put(c, node);
	}

	@Override
	public String toString() {
		return " [node=" + node + ", isEnd=" + isEnd + "]";
	}

	
}
