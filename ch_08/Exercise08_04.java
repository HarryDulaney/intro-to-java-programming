package ch_08;

/**
 * 8.4 (Compute the weekly hours for each employee)
 * Suppose the weekly hours for all employees are stored
 * in a two-dimensional array. Each row records an employee's
 * seven-day work hours with seven columns. For example, the
 * following array stores the work hours for eight employees.
 * Write a program that displays employees and their total
 * hours in decreasing order of the total hours.
 */
public class Exercise08_04 {
    public static void main(String[] args) {

        int[][] employeeHours = {
                {2, 4, 3, 4, 5, 8, 8},  //emp0
                {7, 3, 4, 3, 3, 4, 4},  //emp1
                {3, 3, 4, 3, 3, 2, 2},  //emp2
                {9, 3, 4, 7, 3, 4, 1},  //emp3
                {3, 5, 4, 3, 6, 3, 8},  //emp4
                {3, 4, 4, 6, 3, 4, 4},  //emp5
                {3, 7, 4, 8, 3, 8, 4},  //emp6
                {6, 3, 5, 9, 2, 7, 9}}; //emp7


        int[][] sumHours = new int[8][2];

        for (int row = 0; row < employeeHours.length; row++) {
            for (int column = 0; column < employeeHours[row].length; column++) {

                sumHours[row][0] += employeeHours[row][column];
            }
            sumHours[row][1] = row; //Save original index for sort function
        }

//		Arrays.sort(sumHours); //built in sort
        //Selection Sort
        for (int i = 0; i < sumHours.length - 1; i++) {
            for (int j = i + 1; j < sumHours.length; j++) {
                if (sumHours[i][0] < sumHours[j][0]) {
                    int[] tmp = sumHours[i];
                    sumHours[i] = sumHours[j];
                    sumHours[j] = tmp;
                }

            }
        }
        printArray(sumHours);

    }

    public static void printArray(int[][] array) {

//		for(int i = array.length - 1; i >= 0; i--) { //Print in reverse
        for (int i = 0; i < array.length; i++) {
            System.out.print("Employee number: " + array[i][1] + "'s total hours for the week were ");
            System.out.print(array[i][0] + "\n");
//		}
        }


    }

}
