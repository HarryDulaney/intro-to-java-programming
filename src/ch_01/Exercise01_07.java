package ch_01;


public class Exercise01_07 {
	public static void main(String[] args) {
		
		double approxPi = 4 * (1.0 - 1.0/3 + 1.0/5 - 1.0/7 + 1.0/9 - 1.0/11);
		double approxPi2 = 4 * (1.0 - 1.0/3 + 1.0/5 - 1.0/7 + 1.0/9 - 1.0/11 + 1.0/13);

		System.out.println(approxPi);
		System.out.println(approxPi2);
		System.out.println(Math.PI);
	}
	

}
