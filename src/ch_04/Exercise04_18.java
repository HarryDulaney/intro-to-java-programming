package ch_04;

import java.util.Scanner;

public class Exercise04_18 {
	public static void main(String [] args) {
		
		//student major and status
		
		System.out.println("Please enter two characters Ex.(C3), M, C, or I for your major \nand "
				+ "1 thru 4, for your status. (1 being"
				+ "\nfreshman and 4 being senior)");
		
		Scanner input = new Scanner(System.in);
		String statusCode = input.nextLine();
		
		char major = statusCode.charAt(0);
		char statusYear = statusCode.charAt(1);
		
		String s1 = "";
		String s2 = "";
		
		if (major == 'M') {
			 s1 = "Mathematics";
		}
			else if (major == 'C') {
				 s1 = "Computer Science";}
			else if (major == 'I') {
				 s1 = "Information Technology";}
		
		if (statusYear == '1') {
			 s2 = "Freshman";
		}
			else if (statusYear == '2') {
				 s2 = "Sophmore";}
			else if(statusYear == '3') {
				 s2 = "Junior";}
			else if(statusYear == '4') {
				 s2 = "Senior";}
		
		System.out.println(s1 + " " + s2);
		}
			}
		
		
		
		


