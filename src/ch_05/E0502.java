package ch_05;

/*5.2 (Repeat additions) Listing 5.4
 * SubtractionQuizLoop.java generates five random subtraction questions.
 * Revise the program to generate ten random addition questions for two 
 * integers between 1 and 15. 
 * Display the correct count and test time.
 */
import java.util.Scanner;

public class E0502 {
  public static void main(String[] args) {
	  
	  final int NUMBER_OF_QUESTIONS = 10; // Number of questions
	    int correctCount = 0; // Count the number of correct answers
	    int count = 0; // Count the number of questions
	    long startTime = System.currentTimeMillis();
	    String output = " "; // output string is initially empty
	    
	    Scanner input = new Scanner(System.in);
	    
	    while (count < NUMBER_OF_QUESTIONS) {
	      
	      int number1 = 1 + (int)(Math.random() * 15);
	      int number2 = 1 + (int)(Math.random() * 15);
	     
	      System.out.println("What is " + number1 + " + " + number2 + "? ");
	      int answer = input.nextInt();

	      if (number1 + number2 == answer) {
	        System.out.println("You are correct!\n");
	        correctCount++;
	      }
	      else
	        System.out.println("Your answer is wrong.\n" + number1 
	          + " + " + number2 + " should be " + (number1 + number2) + "\n");

	     
	      count++;

	      output += "\n" + number1 + "+" + number2 + "=" + answer + 
	        ((number1 + number2 == answer) ? " correct" : " wrong");
	    }

	    long endTime = System.currentTimeMillis();
	    long testTime = endTime - startTime;
	    

	    System.out.println("Correct Count is " + correctCount + 
	      "\nTest time is " + testTime / 1000 + " seconds\n" + output);
	  
  }
}