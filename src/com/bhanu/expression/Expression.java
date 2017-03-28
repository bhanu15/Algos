package com.bhanu.expression;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Expression {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String expression ="(2+2+(3*3+5))" ;//scanner.nextLine();
//		(2+2+(3*3+5))
		System.out.println(convertToPostFix(expression));
	}

	public static int evaluate(String expression) {
		return 0;
	}

	private static String convertToPostFix(String input) {
		Stack<String> stack = new Stack<String>();
		String postFix = "";
		HashMap<String, Priority> operators = new HashMap<String, Priority>();
		String opeingBrace = "(";
		String closingBrace = ")";
		String add = "+";
		String minus = "-";
		String multiply = "*";
		String divide = "/";

		operators.put(add, Priority.Add);
		operators.put(minus, Priority.Subtract);
		operators.put(multiply, Priority.Multiply);
		operators.put(divide, Priority.Divide);

		String[] expression = input.split("");
		for (String e : expression) {
			if (e.equals("")) {
				continue;
			}

			if (e.equals(opeingBrace)) {
				stack.push(e);
				continue;
			}

			if (e.equals(closingBrace)) {
				String subExp = "";
				int count = 0;
				while (!stack.isEmpty() && count < 1) {
					if (stack.peek().equals(opeingBrace)) {
						stack.pop();
						break;
					}
					subExp = stack.pop() + subExp;
					count++;

				}
				postFix = postFix.concat(subExp);
				continue;
			}

			if (!operators.containsKey(e)) {
				postFix = postFix.concat(e);
				continue;
			}
			if (stack.isEmpty()) {
				stack.push(e);
				continue;
			}
			String operator = stack.peek();

			Priority priorityOnStack = operators.get(operator);
			Priority newPriority = operators.get(e);
			if (priorityOnStack != null
					&& priorityOnStack.compareTo(newPriority) >= 0) {
				postFix = postFix.concat(stack.pop());
				stack.push(e);
			} else {
				stack.push(e);
			}
		}
		return postFix;
	}
}
