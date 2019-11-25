package ch_06;

/*6.8 (Conversions between Celsius and Fahrenheit)
 * Write a class that contains the following two methods:
 * Convert from Celsius to Fahrenheit */
//public static double celsiusToFahrenheit(double celsius)
//Convert from Fahrenheit to Celsius */
 //public static double fahrenheitToCelsius(double fahrenheit)


public class Exercise06_08 {
	public static void main(String[] args) {
		
		System.out.print("Celsius     ");
		System.out.print("Fahrenheit     ");
		System.out.print("|     Fahrenheit     ");
		System.out.println("Celsius   ");
		System.out.print("-------------------------------------------------------");
		double celsius= 40.0;
		double fahrenheit = 120.0;
		
		while(celsius >= 31.0 && fahrenheit >= 30.0) {
			
		 System.out.println();
		 System.out.printf("%-12.1f%-14.1f",celsius,celsiusToFahrenheit(celsius));
	     System.out.printf(" |%10.1f%15.2f",fahrenheit,fahrenheitToCelsius(fahrenheit));
			
		 celsius -= 1.0;
		 fahrenheit -= 10.0;
			
		}
		
		
	}
	
	public static double celsiusToFahrenheit(double celsius) {
		
		double Fahrenheit = (9.0 / 5) * celsius + 32;
	
		return Fahrenheit;
}
	public static double fahrenheitToCelsius(double fahrenheit) {
		
		double celsius = (5.0 / 9) * (fahrenheit - 32);
		return celsius;
	}
}