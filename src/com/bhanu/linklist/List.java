package com.bhanu.linklist;

public class List {

	private Node head ;
	public List(Node head){
		this.head = head;
	}
	
	public List(){
	}
	private void add(Node head , int data){
		
		if(head.next != null){
			add(head.next , data);
		}else{
			head.next = new Node(data);
		}
	}
	
	
	
	public void add(int data){
		if(head == null){
			head = new Node(data);
			return ;
		}
		add(head , data);
	}
	
	
	public void insert(int data){
		head = insert(head , data);
	}
	
	private Node insert(Node head , int data){
		if(head == null){
			head = new Node(data);
			return head;
		}else{
		head.next = insert(head.next,data );
		
		return head;
		}
	}
	
	public void display(){
		display(head);
	}
	private void display(Node head){
		if(head != null){
			System.out.println(head);
			display(head.next);
		}
	}
	
	public void reverse(){
		Node head = this.head;
		head = reverse(head);
		head.next = null;
	}
	
	private Node reverse(Node head){
		if(head.next == null){
			this.head = head;
			return head;
		}else{
			Node previous = reverse(head.next);
			previous.next = head;
			return head;
		}
	}
	
	
	public Node iterativeReverse(Node head){
		Node previous = null;
		Node next= null;
		while(head.next != null){
			next = head.next;
			head.next = previous;
			previous = head;
			head = next;
		}
		head.next = previous;
		return head;
	}
	public static void main(String[] args) {
		List list = new List();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.insert(8);
		list.insert(9);
		list.display();
//		System.out.println("nth node "+list.nthNode(10));
//		System.out.println("kth element "+list.nthNode(5));
		list.blockReverse(3);
		System.out.println("block reverse ");
		list.display();
	}
	
	
	
	public Node nthNode(int n){
		Node head = this.head;
		Node fast = head;
		while(fast.next != null && kthNode(fast,n) != null  && head.next != null){
			head = head.next;
			fast = kthNode(fast, n);
		}
		return head;
	}
	
	
	public Node kthNode(Node head ,int k){
		int i=0;
		while(head.next != null && i<k ){
			i++;
			head = head.next;
		}
		return i==k?head:null;
	}
	
	public void blockReverse(int k){
		Node head = this.head;
		Node start = head;
		Node previous = null;
		for(int i=0;i<k && head != null;){
			i++;
			if(i%k ==0){
				Node next = head.next;
				head.next = null;
				if(previous == null){
					this.head= iterativeReverse(start);
				}else{
					Node temp = iterativeReverse(start);
					previous.next = temp;
				}
				previous = start;
				start.next = next;
				head = next;
				start = next;
				i=0;
				continue;
				
			}else{
				head  = head.next;
			}
			
		}
	}
}
