package ch_08.exercises;

/*8.4 (Compute the weekly hours for each employee) 
 * Suppose the weekly hours for all employees are stored 
 * in a two-dimensional array. Each row records an employee�s 
 * seven-day work hours with seven columns. For example, the 
 * following array stores the work hours for eight employees. 
 * Write a program that displays employees and their total
 * hours in decreasing order of the total hours.
 */

import java.util.Arrays;

public class E0804 {
	public static void main(String[] args) {
		
		int[][] employeeHours = {
				{2,4,3,4,5,8,8},  //emp0
				{7,3,4,3,3,4,4},  //emp1
				{3,3,4,3,3,2,2},  //emp2
				{9,3,4,7,3,4,1},  //emp3
				{3,5,4,3,6,3,8},  //emp4
				{3,4,4,6,3,4,4},  //emp5
				{3,7,4,8,3,8,4},  //emp6
				{6,3,5,9,2,7,9}}; //emp7
		
		
		int[] sumHours = new int [8];
		
		
			for(int row = 0; row < employeeHours.length; row++) {
				for(int column = 0; column < employeeHours[row].length; column++) {
					
					sumHours[row] += employeeHours[row][column];
			}
		}
			
		Arrays.sort(sumHours);
		
		printArray(sumHours);	
		
	}
	public static void printArray(int[]array) {
		
		for(int i = array.length - 1; i >= 0; i--) {
			
			System.out.print("Employee " + i + "'s total hours for the week were ");
			System.out.println(array[i]);
		}
		
	}

}
