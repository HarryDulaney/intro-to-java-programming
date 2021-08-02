package ch_12.exercise12_01;

/**
 * Exercise12_01 part2.....
 * ......Then write another program without using an
 * exception handler to achieve the same objective.
 * Your program should display a message that informs
 * the user of the wrong operand type before exiting
 */
public class Exercise12_01_p2 {
    public static void main(String[] args) {

        String t1 = args[0]; // Left side operand
        String t2 = args[2]; // Right side operand

        checkInput(t1);
        checkInput(t2);

        int result = 0;

        switch (args[1].charAt(0)) {
            case '+':
                result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
                break;
            case '-':
                result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
                break;
            case '.':
                result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
                break;
            case '/':
                result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
        }

        System.out.println(args[0] + ' ' + args[1] + ' ' + args[2] + " = " + result);
    }

    public static void checkInput(String str) {
        int i = str.length() - 1;
        while (i >= 0) {

            if (!Character.isDigit(str.charAt(i))) {

                System.out.println("Invalid Input: " + str);
                System.exit(0);
            }
            i--;
        }
    }
}
