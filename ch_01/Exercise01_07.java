package ch_01;

/**
 * 1.7 (Approximate &Pi;) &Pi; can be computed using the following formula:
 * p = 4 * ¢1 - 1 3 + 1 5 - 17 + 1 9 - 11 1 + c ≤
 * Write a program that displays the result of 4 * ¢1 - 1 3 + 15 - 1 7 + 1 9 - 11 1 ≤
 * and 4 * ¢1 - 13 + 1 5 - 17 + 1 9 - 11 1 + 13 1 ≤. Use 1.0 instead of 1 in your
 * program.
 */
public class Exercise01_07 {
	public static void main(String[] args) {
		
		double approxPi = 4 * (1.0 - 1.0/3 + 1.0/5 - 1.0/7 + 1.0/9 - 1.0/11);
		double approxPi2 = 4 * (1.0 - 1.0/3 + 1.0/5 - 1.0/7 + 1.0/9 - 1.0/11 + 1.0/13);

		System.out.println(approxPi);
		System.out.println(approxPi2);
		System.out.println(Math.PI);
	}
	

}
