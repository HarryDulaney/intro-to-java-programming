package ch_05;

public class Exercise05_04 {
	public static void main(String[] args) {
		
		final double MILES_PER_KILOMETERS = 1.609;
		
		System.out.println("Miles     Kilometers");
		
		for(int i = 1; i <= 10; i++) {
			
			System.out.printf("%-10d%4.1f\n", i ,(i * MILES_PER_KILOMETERS));
		}
	}

}
