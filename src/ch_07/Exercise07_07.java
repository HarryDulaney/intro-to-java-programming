package ch_07;

public class Exercise07_07 {
	public static void main(String[] args) {
		
		int [] randNumbers = new int [100];
		int [] counts = new int[10];
		
		for (int i = 0; i < randNumbers.length; i++) {
			
			int randomNumber = (int)(Math.random() * 10);
			
			randNumbers[i] = randomNumber;
			
			counts[randomNumber]++;
			
		}
		
		for(int i = 0; i < counts.length; i++) {
			System.out.println("The number at " + i + "'s is: " + counts[i]);
		}
		
	}

}
