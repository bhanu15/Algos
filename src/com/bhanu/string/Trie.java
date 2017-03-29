package com.bhanu.string;

public class Trie {
	private Node head = new Node();
	
	public void insert(String  input){
		Node head = this.head;
		Node temp = null;
		for(char c : input.toCharArray()){
			if(this.head.node.isEmpty()){
				temp = new Node();
				this.head.node.put(c,temp );
				head.node.put(c, temp);
				this.head = head;
				head=  temp;
				continue;
			}
			if(head.node.containsKey(c)){
				head = head.node.get(c);
			}else{
				temp = new Node();
				head.node.put(c , temp);
				head= temp;
			}
		}
		head.isEnd = true;
	}
	
	public boolean isPresent(String input){
		Node head = this.head;
		for(Character c : input.toCharArray()){
			if(!head.node.containsKey(c)){
				return false;
			}else{
				head = head.node.get(c);
			}
		}
		return head.isEnd;
	}
	public static void main(String[] args) {
		Trie trie = new Trie();
		String input = "ABC";
		String inputs[] = {"ABC" , "A" , "BB" , "CD" , "XYZ"};
		
		for(String s: inputs){
//			System.out.println(s);
			trie.insert(s);
		}
		trie.insert(input);
		trie.insert("A");
		trie.insert("XYZ");
		System.out.println(trie.isPresent("ABC"));
		System.out.println(trie.isPresent("BB"));
	}
	
}
