package ch_20;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 20.3 (Guessing the capitals) Rewrite Programming Exercise 8.37 to store the pairs
 * of states and capitals so that the questions are displayed randomly.
 * {@link ch_08.Exercise08_37}
 */
public class Exercise20_03 {
    private static int correct = 0;
    private static int incorrect = 0;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[][] statesAndTheirCapitals = {
                {"Alabama", "Montgomery"}, {"Alaska", "Juneau"}, {"Arizona", "Phoenix"},
                {"Arkansas", "Little Rock"}, {"California", "Sacramento"},
                {"Colorado", "Denver"}, {"Connecticut", "Hartford"},
                {"Delaware", "Dover"}, {"Florida", "Tallahassee"},
                {"Georgia", "Atlanta"}, {"Hawaii", "Honolulu"}, {"Idaho", "Boise"},
                {"Illinois", "Springfield"}, {"Indiana", "Indianapolis"},
                {"Iowa Des", "Moines"}, {"Kansas", "Topeka"}, {"Kentucky", "Frankfort"},
                {"Louisiana", "Baton Rouge"}, {"Maine", "Augusta"},
                {"Maryland", "Annapolis"}, {"Massachusetts", "Boston"},
                {"Michigan", "Lansing"}, {"Minnesota", "Saint Paul"},
                {"Mississippi", "Jackson"}, {"Missouri", "Jefferson City"},
                {"Montana", "Helena"}, {"Nebraska", "Lincoln"},
                {"Nevada", "Carson City"}, {"New Hampshire", "Concord"},
                {"New Jersey", "Trenton"}, {"New Mexico", "Santa Fe"},
                {"New York", "Albany"}, {"North Carolina", "Raleigh"},
                {"North Dakota", "Bismarck"}, {"Ohio", "Columbus"},
                {"Oklahoma", "Oklahoma City"}, {"Oregon", "Salem"},
                {"Pennsylvania", "Harrisburg"}, {"Rhode Island", "Providence"},
                {"South Carolina", "Columbia"}, {"South Dakota", "Pierre"},
                {"Tennessee", "Nashville"}, {"Texas", "Austin"},
                {"Utah", "Salt Lake City"}, {"Vermont", "Montpelier"},
                {"Virginia", "Richmond"}, {"Washington", "Olympia"},
                {"West Virginia", "Charleston"}, {"Wisconsin", "Madison"},
                {"Wyoming", "Cheyenne"}};

        List<String[]> capitals = Arrays.asList(statesAndTheirCapitals);

        boolean keepPlaying = true;
        while (!capitals.isEmpty() && keepPlaying) {
            int random = (int) (Math.random() * capitals.size());
            Collections.shuffle(capitals);
            System.out.print("What is the capital of " + capitals.get(random)[0] + "? ");
            String userInput = input.next();

            if (capitals.get(random)[1].equalsIgnoreCase(userInput)) {
                System.out.println("Your answer is correct");
                correct++;
            } else {
                System.out.println("Your answer is incorrect. The correct answer is: " + capitals.get(random)[1]);
                incorrect++;
            }
            System.out.println("Keep playing? Enter Y or N: ");
            String response = input.next();
            keepPlaying = response.equalsIgnoreCase("Y");
            final String stateAsked = capitals.get(random)[0];
            // Filter out the current State string value
            capitals = capitals.stream().filter(i -> !i[0].equalsIgnoreCase(stateAsked)).collect(Collectors.toList());
        }
        input.close();

        System.out.println("Thanks for playing, the final score is: ");
        System.out.println(correct + " correct.");
        System.out.println(incorrect + " incorrect.");


    }

}
