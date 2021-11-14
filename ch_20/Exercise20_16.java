package ch_20;

import java.util.Stack;

/**
 * **20.16 (Convert infix to postfix) Write a method that converts an infix expression into
 * a postfix expression using the following header:
 * public static String infixToPostfix(String expression)
 * For example, the method should convert the infix expression (1 + 2) * 3 to
 * 1 2 + 3 * and 2 * (1 + 3) to 2 1 3 + *.
 */
public class Exercise20_16 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(
                    "Usage: java Exercise20_16 {expression}");
            System.exit(1);
        }

        String expression = "";
        for (int i = 0; i < args.length; i++) {
            expression += args[i];
        }

        try {
            System.out.println(infixToPostfix(expression));
        } catch (Exception ex) {
            System.out.println("Wrong expression");
        }
    }

    public static String infixToPostfix(String expression) {
        String result = "";

        Stack<Character> operatorStack = new Stack<>();
        java.util.StringTokenizer tokens =
                new java.util.StringTokenizer(expression, "()+-/*%", true);

        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken().trim(); // Extract a token
            if (token.length() == 0) {
                continue;
            } else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek().equals('+') ||
                                operatorStack.peek().equals('-') ||
                                operatorStack.peek().equals('*') ||
                                operatorStack.peek().equals('/')
                        )) {
                    result += operatorStack.pop() + " ";
                }

                operatorStack.push(new Character(token.charAt(0)));
            } else if (token.charAt(0) == '*' || token.charAt(0) == '/') {

                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek().equals('*') ||
                                operatorStack.peek().equals('/')
                        )) {
                    result += operatorStack.pop() + " ";
                }

                operatorStack.push(new Character(token.charAt(0)));
            } else if (token.trim().charAt(0) == '(') {
                operatorStack.push(new Character('('));
            } else if (token.trim().charAt(0) == ')') {
                while (!operatorStack.peek().equals('(')) {
                    result += operatorStack.pop() + " ";
                }

                operatorStack.pop();
            } else {
                result += token + " ";
            }
        }
        while (!operatorStack.isEmpty()) {
            result += operatorStack.pop() + " ";
        }
        return result;
    }
}
