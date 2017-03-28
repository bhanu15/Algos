package com.bhanu.expression;

public enum Priority implements Comparable<Priority>{

	Add(1), Subtract(2), Multiply(3), Divide(4);

	private int priority;

	private Priority(int priority) {
		this.priority = priority;
	}
	
}
