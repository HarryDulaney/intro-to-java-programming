package ch_04;

/**
 * *4.25 (Generate vehicle plate numbers) Assume a vehicle plate number consists of three
 * uppercase letters followed by four digits. Write a program to generate a plate
 * number.
 */
public class Exercise04_25 {
    public static void main(String[] args) {

        String plateNumber = "";

        int i = 0;
        while (i < 3) {

            plateNumber += (char)(65 + Math.random() * (91-65));
            i++;
        }

        for(int j = 0; j < 4; j++) {

            plateNumber += (int)(1 + Math.random() * 9);
        }

        System.out.println(plateNumber);

    }
}
