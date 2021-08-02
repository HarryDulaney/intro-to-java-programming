package ch_10;

/**
 * 10.26 (Calculator) Revise Listing 7.9, Calculator.java, to accept an expression as
 * a string in which the operands and operator are separated by zero or more
 * spaces. For example, 3+4 and 3 + 4 are acceptable expressions.
 */
public class Exercise10_26 {
    public static void main(String[] args) {

        StringBuilder str = new StringBuilder();

        for (String arg : args) {
            str.append(arg);
        }

        String str2 = str.toString().replaceAll(" ", "");

        str2 = str2.replaceAll("[+]", "%+%");
        str2 = str2.replaceAll("[-]", "%-%");
        str2 = str2.replaceAll("[.]", "%.%");
        str2 = str2.replaceAll("[/]", "%/%");


        args = str2.split("%");

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
                break;

        }
        System.out.println(args[0] + ' ' + args[1] + ' ' + args[2] + " = " + result);
    }

}