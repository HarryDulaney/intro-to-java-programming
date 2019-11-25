package ch_04;


import java.util.Scanner;

public class Exercise04_24 {
	public static void main(String[] args) {
		
		String tempCity = "";
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the name of city 1: ");
		String cityOne = input.next();
		
		System.out.print("Enter the name of city 2: ");
		String cityTwo = input.next();
		
		System.out.print("Enter the name of city 3: ");
		String cityThree = input.next();
		
		if(cityOne.charAt(0) > cityTwo.charAt(0)) {
			tempCity = cityTwo;
			cityTwo = cityOne;
			cityOne = tempCity;
			
		if(cityTwo.charAt(0) > cityThree.charAt(0)) {
			tempCity = cityThree;
			cityThree = cityTwo;
			cityTwo = tempCity;
		}
			
		
		
		}
			
		System.out.println("The cities in alphabetical order are: "
				+ cityOne + " " + cityTwo + " " + cityThree + "." );
		
		
	}

}
