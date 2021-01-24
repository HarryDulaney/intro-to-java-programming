package ch_05;

/*5.40 (Simulation: heads or tails) Write a program that simulates flipping 
 * a coin one million times and displays the number of heads and tails. 
 */

public class Exercise05_40 {
	public static void main(String[] args) {
		
		System.out.println("This program simulates flipping a coin one million times!\n"
				 + "Here are the results:\n");
		
		int heads = 0;
		int tails = 0;
		int count = 0;
		
		while(count++ < 1000000) {
			double headsOrtails = Math.random();
			
			if (headsOrtails > 0.5) {
				++heads;
			}
			else {
				++tails;
			}
			
		}
			System.out.println("Number of heads: " + heads);	
			System.out.println("Number of tails: " + tails);
		
		
		
		
		
	}

}
