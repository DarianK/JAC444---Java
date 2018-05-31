/**
Submitted By: Darian Koarga
Course: JAC444
Date: May 30, 2018
Id: 136296167
Contains Task 1, Location class implementation
*/

import java.util.Scanner;

public class Location {
		int row, column;
		double maxValue;

		public static Location locateLargest(double[][]a) {
			Location locate = new Location(); //create a Location variable and assign a new Location object to it
			//initialize values for new object
			locate.row = 0;
			locate.column = 0;
			locate.maxValue = a[0][0];
			//loop through array to locate largest array value and coordinates
			for(int i = 0; i < a.length; i++) {
				for(int j = 0; j < a[i].length; j++) {
				if(a[i][j] > locate.maxValue) {
					//set row, column and maxValue to located values
					locate.row = i;
					locate.column = j;
					locate.maxValue = a[i][j];
				}
			}
		}
			return locate; //return located results
		}
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in); //create scanner object
    System.out.print("Enter the number of rows and columns in the array: ");
    int row = input.nextInt(); //accept user input for number of rows
    int column = input.nextInt(); //accept user input for number of columns
    double [][] matrix = new double [row][column]; //create a 2d array using user input
		System.out.println("Enter the array: ");
		//loop through newly created array and accept array values from user
    for(int i = 0; i < matrix.length; i++) {
    	for(int j = 0; j < matrix[i].length; j++) {
    		matrix[i][j] = input.nextDouble();
    	}
    }
		//call locateLargest function
		Location A = locateLargest(matrix);
		//print results gathered from locateLargest
		System.out.println("The location of the largest element is " + String.format("%.0f", A.maxValue) + " at (" + A.row + ", " + A.column + ")");
	}
}
