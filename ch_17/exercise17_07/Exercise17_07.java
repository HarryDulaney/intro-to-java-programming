package ch_17.exercise17_07;

import ch_17.exercise17_01.Exercise17_01;
import ch_17.exercise17_06.Exercise17_06;
import ch_17.exercise17_06.Loan;

import java.io.*;

/**
 * *17.7 (Restore objects from a file) Suppose a file named Exercise17_07.dat has been
 * created using the ObjectOutputStream. The file contains Loan objects. The
 * Loan class in Listing 10.2 does not implement Serializable. Rewrite the
 * Loan class to implement Serializable. Write a program that reads the Loan
 * objects from the file and displays the total loan amount. Suppose you don’t
 * know how many Loan objects are there in the file, use EOFException to end
 * the loop.
 */
public class Exercise17_07 {
    public static void main(String[] args) {
        String[] packageParts = Exercise17_01.class.getPackage().getName().split("\\.");
        String path = packageParts[0] + File.separator + packageParts[1] + File.separator +
                "Exercise17_07" +
                ".dat";


        File outFile = new File(path);
        if (!outFile.exists()) {
            writeLoanObjs(outFile);
        }
        handleRead(outFile);
    }

    static void handleRead(File file) {
        try {
            double d = readLoanObjects(file);
            System.out.printf("The total amount of all loans is %.2f", d);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong reading the loan objects:  IOException....");
        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
            System.out.println("Loan object class was not recognized....");
        }
    }

    static double readLoanObjects(File file) throws ClassNotFoundException, IOException {
        double sum = 0;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                Loan loan = (Loan) objectInputStream.readObject();
                System.out.println("Adding loan amount " + loan.getLoanAmount() + " to Total Loans");
                sum += loan.getLoanAmount();
            }
        } catch (EOFException eofException) {
            System.out.println("Reading finished...End of file reached...");
        }
        return sum;
    }

    static void writeLoanObjs(File file) {
        Loan l1 = new Loan(6.5, 10, 210320);
        Loan l2 = new Loan(4.7, 10, 93800);
        Loan l3 = new Loan(3.9, 10, 50230);
        Loan l4 = new Loan(11.5, 10, 21000);
        Loan l5 = new Loan(2.5, 10, 172000);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(l1);
            oos.writeObject(l2);
            oos.writeObject(l3);
            oos.writeObject(l4);
            oos.writeObject(l5);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

}