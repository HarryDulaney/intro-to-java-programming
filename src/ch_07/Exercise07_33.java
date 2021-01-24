package ch_07;

/*7.33 (Culture: Chinese Zodiac) Simplify 
 * Listing 3.9 using an array of strings 
 * to store the animal names.
 */
import java.util.Scanner;

public class Exercise07_33 {
	public static void main(String[] args) {
		
		String[] animalNames = {"monkey","rooster","dog","pig","rat","ox","tiger","rabbit",
				"dragon","snake","horse","sheep"};
		
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Enter the year for which you would like to know your Chinese Zodiac animal:");
		
		int year = input.nextInt();
		
		String toPrint = animalNames[year % 12];
		
		System.out.println(toPrint);
		
		
	
	}

}
