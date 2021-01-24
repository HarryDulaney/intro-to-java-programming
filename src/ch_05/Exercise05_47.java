package ch_05;

import java.util.*;

/**
 * *5.47 (Business: check ISBN-13) ISBN-13 is a new standard for identifying books. It
 * uses 13 digits d1d2d3d4d5d6d7d8d9d10d11d12d13. The last digit d13 is a checksum,
 * which is calculated from the other digits using the following formula:
 * 10 - (d1 + 3d2 + d3 + 3d4 + d5 + 3d6 + d7 + 3d8 + d9 + 3d10 + d11 + 3d12)%10
 * If the checksum is 10, replace it with 0. Your program should read the input as a
 * string.
 * <p>
 * <strong>Here are sample runs:</strong>
 * <p>
 * {@code Enter the first 12 digits of an ISBN-13 as a string: 978013213080
 * The ISBN-13 number is 9780132130806
 * <p>
 * Enter the first 12 digits of an ISBN-13 as a string: 978013213079
 * The ISBN-13 number is 9780132130790
 * <p>
 * Enter the first 12 digits of an ISBN-13 as a string: 97801320
 * 97801320 is an invalid input}
 */
public class Exercise05_47 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the first 12 digits of an ISBN-13 as a string: ");
        String isbn = in.nextLine();

        // Verify string length
        if (isbn.length() != 12) {
            System.out.println("Invalid input " + isbn + " input MUST be exactly 12 numbers");
            System.exit(0);
        }

        int check = 0;
        for (int i = 0; i < isbn.length(); i++) {
            int value = Integer.parseInt(String.valueOf(isbn.charAt(i)));
            check += i % 2 == 0 ? 3 * value
                    : value;
        }
        check = 10 - check % 10;
        
        System.out.println("ISBN-13 number is " + isbn +
                (check == 10 ? 0 : check));

        in.close();
    }
}