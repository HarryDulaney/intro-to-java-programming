package Ch_05;



import java.util.Scanner;

public class Exercise05_07 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		double highScore = 0;
		String studentName = " ";
		
		System.out.print("Enter the number of students: ");
		int numberOfstudents = input.nextInt();
		
		System.out.print("Enter a student name: ");
		studentName = input.next();
		
		System.out.print("Enter the students score: ");
		highScore = input.nextDouble();
		
		String tempName = "";
		double tempScore = 0;
		
		while ( numberOfstudents > 1 ) {
			
			System.out.print("Enter a student name: ");
			tempName = input.next();
			
			System.out.print("Enter the students score: ");
			tempScore = input.nextDouble();
			
			if(tempScore > highScore)
				highScore = tempScore;
				studentName = tempName;
			
			
			numberOfstudents--;	
		}
		System.out.println("Top student " + studentName + "'s score is " + highScore);
	}

}
