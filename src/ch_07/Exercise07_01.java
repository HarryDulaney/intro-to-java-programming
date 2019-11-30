package ch_07;

/*7.1 (Assign grades) Write a program that reads student scores, 
 * gets the best score, and then assigns grades based on the following scheme:
*The program prompts the user to enter the total number of students, then 
*prompts the user to enter all of the scores, and concludes by displaying the grades.
 *
 */
import java.util.Scanner;

public class Exercise07_01 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter the total number of students: ");
		
		double[] scores = new double [input.nextInt()];
		
		System.out.println("Enter " + scores.length + " student scores seperated by a space: ");
		
		
		for (int i = 0 ; i < scores.length ; i++) {
			
			scores[i] = input.nextDouble(); }
		
		double highScore = scores[0];
		
			for(int i = 1; i < scores.length; i++ ) {
				if (scores[i] > highScore) {
					highScore = scores[i];
				}
			}
				
			char[] grades = new char[scores.length];
			
			for(int i = 0; i < scores.length; i++) {
				
				if (scores[i] >= highScore - 10) {
					grades[i] = 'A';
				}
				else if( scores[i] >= highScore - 20) {
					grades[i]= 'B';
				}
				else if( scores[i] >= highScore - 30) {
					grades[i] = 'C';
				}
				else if( scores[i] >= highScore - 40) {
					grades[i] = 'D';
				}
				else {
					grades[i] = 'F';	}
				}
		
			for (int i = 0; i < scores.length; i++) {
				System.out.println("Student score " + scores[i] + " is " + grades[i]);
			}
			}
		}


