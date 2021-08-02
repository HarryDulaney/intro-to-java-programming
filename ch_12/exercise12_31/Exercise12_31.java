package ch_12.exercise12_31;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 12.31 (Baby name popularity ranking) The popularity ranking of baby names from
 * years 2001 to 2010 is downloaded from https://www.ssa.gov/oact/babynames and stored
 * in files named babynameranking2001.txt, babynameranking2002.txt, . . . ,
 * babynameranking2010.txt. Each file contains one thousand lines. Each line
 * contains a ranking, a boy’s name, number for the boy’s name, a girl’s name,
 * and number for the girl’s name.
 * <p>
 * For example, the first two lines in the file
 * babynameranking2010.txt are as follows:
 * <p>
 * * 1 Jacob 21,875 Isabella 22,731
 * * 2 Ethan 17,866 Sophia 20,477
 * <p>
 * So, the boy’s name Jacob and girl’s name Isabella are ranked #1 and the boy’s
 * name Ethan and girl’s name Sophia are ranked #2. 21,875 boys are named
 * Jacob and 22,731 girls are named Isabella.
 * <p>
 * Write a program that prompts the
 * user to enter the year, gender, and followed by a name, and displays the ranking
 * of the name for the year.
 * Here is a sample run:
 * <p>
 * Enter the year: 2010
 * Enter the gender: M
 * Enter the name: Javier
 * Javier is ranked #190 in year 2010
 * <p>
 * Enter the year: 2010
 * Enter the gender: F
 * Enter the name: ABC
 * The name ABC is not ranked in year 2010
 */
public class Exercise12_31 {
    private static final String FILENAME_PREFIX = "babynameranking";
    private static final String workingDir = "ch_12/exercise12_31";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = in.nextInt();

        System.out.print("\nEnter the gender: ");
        String gender = in.next().trim();

        System.out.print("\nEnter the name: ");
        String name = in.next();

        int rank = getRank(year, gender.charAt(0), name);
        if (rank == -7) {
            System.out.println("That name is not on the list for that year....");
        }
        System.out.print("\n" + name + " is ranked #" + rank + " in year " + year);

        in.close();

    }

    private static int getRank(int year, char gender, String name) {
        if (year < 2001 || year > 2010) return -1;
        if (gender != 'M' && gender != 'F') return -2;

        int ranking = -7; // invalid name default if not set during do while loop
        String fileName = FILENAME_PREFIX + year + ".txt";
        File file = new File(workingDir, fileName);

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String[] line = fileScanner.nextLine().split("\\s+"); //Example: 1	Jacob	32,550	Emily	25,057
                if (gender == 'M') {
                    if (line[1].equalsIgnoreCase(name)) {
                        ranking = Integer.parseInt(line[0].trim());
                        break;
                    }
                } else {
                    if (line[3].equalsIgnoreCase(name)) {
                        ranking = Integer.parseInt(line[0].trim());
                        break;
                    }
                }
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return ranking;
    }
}
