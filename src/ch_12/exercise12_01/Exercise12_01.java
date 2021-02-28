package ch_12.exercise12_01;

/**
 * 12.1 (NumberFormatException) Listing 7.9 Calculator.java, is
 * a simple command-line calculator. Note that the program terminates
 * if any operand is non-numeric. Write a program with an exception
 * handler that deals with non-numeric operands.
 */
public class Exercise12_01 {
    public static void main(String[] args) {

        if (new Exercise12_01().checkInput(args)) { // Check for non-numeric operands in args[]
            int result = 0;

            switch (args[1].charAt(0)) {
                case '+':
                    result = Integer.parseInt(args[0]) +
                            Integer.parseInt(args[2]);
                    break;
                case '-':
                    result = Integer.parseInt(args[0]) -
                            Integer.parseInt(args[2]);
                    break;
                case '.':
                    result = Integer.parseInt(args[0]) *
                            Integer.parseInt(args[2]);
                    break;
                case '/':
                    result = Integer.parseInt(args[0]) /
                            Integer.parseInt(args[2]);
            }


            System.out.println(args[0] + ' ' + args[1] + ' ' + args[2]
                    + " = " + result);
        }
    }

    /**
     * Terminates the program if the operands in args[] are non-numeric
     *
     * @param args command line args passed in from the console
     * @return true if the method executes fully without throwing a NumberFormatException
     */
    boolean checkInput(String[] args) {
        try {
            Integer.parseInt(args[0]);
        } catch (NumberFormatException ex) {

            System.out.println("Invalid Input: " + args[0]);
            System.exit(1);

        }
        try {
            Integer.parseInt(args[2]);
        } catch (NumberFormatException ex) {

            System.out.println("Invalid Input: " + args[2]);
            System.exit(2);
        }
        return true;
    }

}