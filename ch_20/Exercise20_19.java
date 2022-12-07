package ch_20;

import java.util.Stack;

/**
 * ***20.19 (Game: solution ratio for 24-point game) When you pick four cards from a
 * deck of 52 cards for the 24-point game introduced in Programming Exercise
 * 20.13, the four cards may not have a 24-point solution. What is the number
 * of all possible picks of four cards from 52 cards? Among all possible picks,
 * how many of them have 24-point solutions? What is the success ratio—that is,
 * (number of picks with solutions)/ (number of all possible picks of four cards)?
 * Write a program to find these answers.
 */
public class Exercise20_19 {
    static final String[] operators = new String[]{"+", "-", "*", "/"};

    public static void main(String[] args) {
        /* Number of possible picks of four cards from 52 cards? */
        long totalPossibleCombinations = findTotalPossibleCombinations(4, 52);
        System.out.println("Number of possible picks of four cards from 52 card deck? Answer: ");
        System.out.println(totalPossibleCombinations);
        /* Out of all possible picks, how many have 24-point solutions? */
        long numPicksWith24PtTotal = findCombinationsWithTarget(24);
        System.out.println("Out of all possible picks of 4 how many have 24 pt solution? Answer: ");
        System.out.println(numPicksWith24PtTotal);
        /* What is the success ratio (number of picks with solutions)/ (number of all possible picks of four cards)? */
        System.out.println("What is the success ratio (number of picks with solutions)/(number of all possible picks of four cards)? Answer:");
        System.out.println((double) numPicksWith24PtTotal / totalPossibleCombinations);

    }

    /**
     * C(n,r)=n!/(n−r)!r!
     * C = combinations
     * n = total objects
     * r = sample size (slots)
     *
     * @param r sample size
     * @param n number of unique objects
     * @return c
     */
    static long findTotalPossibleCombinations(int r, int n) {
        /* Permutations / Slots! = possible combinations */
        long permutations = 1; // Initialize
        long slots = 1; // Initialize
        int sampleFactor = n;
        int slotsFactor = r;

        while (slotsFactor >= 1) {
            permutations *= sampleFactor;
            slots *= slotsFactor;
            sampleFactor--;
            slotsFactor--;
        }

        return permutations / slots;
    }

    /**
     * c = combinations
     *
     * @param target test and match combination
     * @return combinations summing to 24
     */
    static long findCombinationsWithTarget(int target) {
        int c = 0;
        int[] hearts = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int[] clubs = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int[] spades = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int[] diamonds = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int c1, c2, c3, c4 = 0;
        for (int h = 0; h < hearts.length; h++) {
            c1 = hearts[h];
            for (int cl = 0; cl < clubs.length; cl++) {
                c2 = clubs[cl];
                for (int s = 0; s < spades.length; s++) {
                    c3 = spades[s];
                    for (int d = 0; d < diamonds.length; d++) {
                        c4 = diamonds[d];
                        for (int o1 = 0; o1 < operators.length; o1++) {
                            String op1 = operators[o1];
                            for (int o2 = 0; o2 < operators.length; o2++) {
                                String op2 = operators[o2];
                                for (int o3 = 0; o3 < operators.length; o3++) {
                                    String op3 = operators[o3];
                                    String exp = c1 + op1 + c2 + op2 + c3 + op3 + c4;
                                    if (evalExpression(exp) == target) {
                                        c++;
                                    }
                                }
                            }


                        }

                    }
                }
            }
        }
        return c;
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
