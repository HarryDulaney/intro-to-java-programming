package ch_12.exercise12_24;


import java.io.File;
import java.io.PrintWriter;

/**
 * *12.24 (Create large dataset) Create a data file with 1,000 lines.
 * <p>
 * Each line in the file consists of a faculty member’s first name, last name, rank, and salary.
 * The faculty member’s first name and last name for the ith line are FirstNamei and
 * LastNamei.
 * <p>
 * The rank is randomly generated as assistant, associate, and full.
 * The salary is randomly generated as a number with two digits after the decimal
 * point.
 * <p>
 * The salary for an assistant professor should be in the range from 50,000
 * to 80,000, for associate professor from 60,000 to 110,000, and for full professor
 * from 75,000 to 130,000.
 * <p>
 * Save the file in Salary.txt. Here are some sample data:
 * FirstName1 LastName1 assistant 60055.95
 * FirstName2 LastName2 associate 81112.45
 * . . .
 * FirstName1000 LastName1000 full 92255.21
 */
public class Exercise12_24 {
    final static String FNAME = "FirstName";
    final static String LNAME = "LastName";

    final static String RANK_ASSISTANT = "assistant";
    final static String RANK_FULL = "full";
    final static String RANK_ASSOCIATE = "associate";

    public static void main(String[] args) {
        File file = new File("src\\ch_12\\exercise12_24\\Salary.txt");

        try (PrintWriter printWriter = new PrintWriter(file)) {
            for (int numLines = 1; numLines <= 1000; numLines++) {
                String rank = getRank();    //Randomly generated rank
                double salary = getSalary(rank); //Semi-randomly generated salary

                StringBuilder recordBuilder = new StringBuilder();//Build the record
                recordBuilder.append(FNAME + numLines).append(" ") //First name
                        .append(LNAME + numLines).append(" ")     //Last name
                        .append(rank).append(" ")
                        .append(String.format("%.2f", salary)).append(" ");

                printWriter.println(recordBuilder.toString());
//                System.out.println(recordBuilder.toString());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    static double getSalary(final String rank) {
        double salary = 0.0;
        switch (rank) {
            case RANK_ASSISTANT:
                salary = 50_000 + Math.random() * 30_000;
                break;
            case RANK_ASSOCIATE:
                salary = 60_000 + Math.random() * 50_000;
                break;
            case RANK_FULL:
                salary = 75_000 + Math.random() * 55_000;
                break;
        }
        return salary;
    }

    static String getRank() {
        final int random = (int) (1 + Math.random() * 3);
        String rank = null;
        switch (random) {
            case 1:
                rank = RANK_ASSISTANT;
                break;
            case 2:
                rank = RANK_ASSOCIATE;
                break;
            case 3:
                rank = RANK_FULL;
                break;
        }
        return rank;
    }
}
