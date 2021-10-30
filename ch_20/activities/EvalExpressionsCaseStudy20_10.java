package ch_20.activities;

import java.util.Stack;

/**
 * Phase 1: Scanning the expression This program scans the expression from left
 * to right to extract operands, operators, and the parentheses. 1.1. If the
 * extracted item is an operand, push it to operandStack. 1.2. If the extracted
 * item is a + or - operator, process all the operators at the top of
 * operatorStack and push the extracted operator to operatorStack. 1.3. If the
 * extracted item is a * or / operator, process the * or / operators at the top
 * of operatorStack and push the extracted operator to operatorStack.
 *
 * 1.4. If the extracted item is a ( symbol, push it to operatorStack. 1.5. If
 * the extracted item is a ) symbol, repeatedly process the operators from the
 * top of operatorStack until seeing the ( symbol on the stack. Phase 2:
 * Clearing the stack Repeatedly process the operators from the top of
 * operatorStack until operatorStack is empty. Table 20.1 shows how the
 * algorithm is applied to evaluate the expression (1 + 2) * 4 - 3.
 */
public class EvalExpressionsCaseStudy20_10 {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println(
					"Please input your expression like this:" + "\njava EvalExpressionsCaseStudy20_10 (1 + 2) * 4 - 3");
			System.exit(0);
		}

		try {
			System.out.println(evalExpression(args[0]));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static int evalExpression(String exp) {
		// Stack to store the operands
		Stack<Integer> operandStack = new Stack<>();

		// Stack to store operators
		Stack<Character> operatorStack = new Stack<>();

		// Delimit expression with spaces to make consistent for evaluating
		exp = delimit(exp);

		String[] tokens = exp.split(" ");

		for (String token : tokens) {
			if (token.length() == 0) { // blank space
				continue;
			} else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
				while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-'
						|| operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
					processOperator(operandStack, operatorStack);
				}
				operatorStack.push(token.charAt(0));

			} else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
				while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
					processOperator(operandStack, operatorStack);
				}
				operatorStack.push(token.charAt(0));

			} else if (token.trim().charAt(0) == '(') {
				operatorStack.push('('); // Push '(' to stack
			} else if (token.trim().charAt(0) == ')') {
				// Process all the operators in the stack until seeing '(
				while (operatorStack.peek() != '(') {
					processOperator(operandStack, operatorStack);
				}
				operatorStack.pop(); // Pop the '(' symbol from the stack
			} else { // An operand scanned
				// Push an operand to the stack
				operandStack.push(new Integer(token));
			}
		}
		// Phase 2: Process all the remaining operators in the stack
		while (!operatorStack.isEmpty()) {
			processOperator(operandStack, operatorStack);
		}
		// Return the result
		return operandStack.pop();
	}

	/**
	 * Process one operator: Take an operator from operatorStack and apply it on the
	 * operands in the operandStack
	 */
	private static void processOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
		char op = operatorStack.pop();
		int op1 = operandStack.pop();
		int op2 = operandStack.pop();
		if (op == '+')
			operandStack.push(op2 + op1);
		else if (op == '-')
			operandStack.push(op2 - op1);
		else if (op == '*')
			operandStack.push(op2 * op1);
		else if (op == '/')
			operandStack.push(op2 / op1);
	}

	private static String delimit(String str) {
		String res = "";

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(' || str.charAt(i) == ')' || str.charAt(i) == '+' || str.charAt(i) == '-'
					|| str.charAt(i) == '/' || str.charAt(i) == '*') {

				res += " " + str.charAt(i) + " ";

			} else {
				res += str.charAt(i);

			}

		}

		return res;
	}

}
