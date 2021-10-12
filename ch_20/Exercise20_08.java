package ch_20;

import java.util.*;

/**
 * *20.8 (Game: lottery) Revise Programming Exercise 3.15 to add an additional $2,000
 * award if two digits from the user input are in the lottery number. (Hint: Sort
 * the three digits in the lottery number and three digits in the user input into two
 * lists, and use the Collection’s containsAll method to check whether the
 * two digits in the user input are in the lottery number.)
 */
public class Exercise20_08 {
    public static void main(String[] args) {
        Random random = new Random();
        int lottery = random.nextInt(999);
        if (lottery < 100) {
            lottery += 99;
        }
        String lotAsStr = lottery + "";

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your lottery pick as an integer of three digits: ");
        String guess = input.nextLine().trim();

        ArrayList<Integer> playedNums = new ArrayList<>();
        ArrayList<Integer> lotNums = new ArrayList<>();
        for (int i = 0; i < guess.length(); i++) {
            playedNums.add(Integer.parseInt(guess.charAt(i) + ""));
        }
        for (int i = 0; i < lotAsStr.length(); i++) {
            lotNums.add(Integer.parseInt(lotAsStr.charAt(i) + ""));
        }


        int matches = numberOfMatches(lotNums, playedNums);
        System.out.println("The lottery number is " + lottery);
        input.close();

        if (lottery == Integer.parseInt(guess)) {
            System.out.println("Exact match: you win $10,000");
        } else if (matches == 3) {
            System.out.println("Match all digits: you win $3,000");
        } else if (matches == 2) {
            System.out.println("Match two digits: you win $2,000");
        } else if (matches == 1) {
            System.out.println("Match one digit: you win $1,000");
        } else {
            System.out.println("Sorry no match, play again!!!");
        }

    }

    static int numberOfMatches(ArrayList<Integer> lotNums, ArrayList<Integer> playedNums) {
        int matched = 0;

        for (int i = 0; i < playedNums.size(); i++) {
            if (lotNums.contains(playedNums.get(i))) {
                matched++;
            }
        }
        return matched;
    }

}
