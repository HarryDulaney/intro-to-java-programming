package ch_21;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * *21.9 (Guess the capitals using maps) Rewrite Programming Exercise 8.37 to store
 * pairs of each state and its capital in a map. Your program should prompt the user
 * to enter a state and should display the capital for the state.
 * <p>
 * {@linkplain ch_08.Exercise08_37}
 */
public class Exercise21_09 {
    public static void main(String[] args) {
        String[][] statesAndCaptials = {
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
                {"Wyoming", "Cheyenne"}
        };

        Map<String, String> stateCapitalsMap = new HashMap<>();
        for (String[] pair : statesAndCaptials) {
            stateCapitalsMap.putIfAbsent(pair[0], pair[1]);
        }

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a state: ");
        String userInput = in.nextLine().trim();

        if (stateCapitalsMap.containsKey(userInput)) {
            System.out.println("The capital of " + userInput + " is " + stateCapitalsMap.get(userInput));
        } else {
            System.out.println("We could not find a capital for the state: " + userInput);
        }

        in.close();
    }

}