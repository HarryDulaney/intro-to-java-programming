package ch_08;

import java.util.Scanner;

/**
 * *8.21 (Central city) Given a set of cities, the central city is the city that has the shortest
 * total distance to all other cities. Write a program that prompts the user to enter
 * the number of the cities and the locations of the cities (coordinates), and finds
 * the central city and its total distance to all other cities.
 * Drop a yellow disk at column (0–6): 3
 * | | | | | | | |
 * | | | | | | | |
 * | | | | | | | |
 * | | | | | | | |
 * | | | | | | | |
 * |R| | |Y| | | |
 * . . .
 * . . .
 * . . .
 * Drop a yellow disk at column (0–6): 6
 * | | | | | | | |
 * | | | | | | | |
 * | | | |R| | | |
 * | | | |Y|R|Y| |
 * | | |R|Y|Y|Y|Y|
 * |R|Y|R|Y|R|R|R|
 * ———————————————
 * The yellow player won
 * Enter the number of cities: 5
 * Enter the coordinates of the cities:
 * 2.5 5 5.1 3 1 9 5.4 54 5.5 2.1
 * The central city is at (2.5, 5.0)
 * The total distance to all other cities is 60.81
 */
public class Exercise08_21 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of cities: ");

        int numCities = input.nextInt();

        double[][] coor = new double[numCities][2];   //Creates two-dimensional array object with each city as row and the 0 and 1 columns as coordinates

        System.out.print("Enter the coordinates of the " + numCities + " cities:");

        for (int i = 0; i < coor.length; i++) {
            for (int j = 0; j < coor[i].length; j++) {

                coor[i][j] = input.nextDouble();   //inputs user coordinates

            }
        }

        double[][] distances = findDistances(coor);  // Creates new two-dimensional array object with distances between each city and the other city

        double[] sumOfDistances = new double[distances.length]; //Creates array object to store the sum of the distances

        for (int i = 0; i < sumOfDistances.length; i++) {
            for (int j = 0; j < sumOfDistances.length; j++) {

                sumOfDistances[i] += distances[i][j];   //Finds the sum of distances for each city, and stores it in the cities
            }
        }
        int indexMin = indexOfMin(sumOfDistances);

        System.out.println("The central city is at (" + coor[indexMin][0] + ", " + coor[indexMin][1] + ")");
        System.out.println("And the total distance to all other cities is " + sumOfDistances[indexMin]);
        input.close();
    }

    public static int indexOfMin(double[] arr) { //returns the index of the lowest sum

        int index = 0;
        double minDistance = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (minDistance > arr[i]) {
                minDistance = arr[i];
                index = i;
            }
        }

        return index;

    }

    public static double[][] findDistances(double[][] arr) {

        double[][] d = new double[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

                double x1 = arr[i][0];
                double x2 = arr[j][0];
                double y1 = arr[i][1];
                double y2 = arr[j][1];

                d[i][j] = Math.pow(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2), 0.5);

            }
        }

        return d;
    }

}