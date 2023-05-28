package Algorithmen_01;

public class SwapArray {

	public static int[][] rotatedArray;

	public static void main(String[] args) {
		RotateArray();
	}

	
	// Print Array as table
		public static void printArray(int[][] Array) {
			for (int i = 0; i < Array.length; i++) {
				for (int j = 0; j < Array[0].length; j++) {
					System.out.print(Array[i][j] + "  ");
				}
				System.out.println();
			}
		}
	
	public static void RotateArray() {

		// Set Array
		int[][] Array = {	{ 3, 5, 7 },
							{ 1, 9, 12 },
							{ 2, 6, 0 },
						 };
		

		// Output Array to Console
		System.out.println("Originaler Array");
		printArray(Array);
		
		// Rotate Array
		rotatedArray = rotateArrayRight(Array);
		
		// Output rotated Array to Console
		System.out.println("\nGedrehter Array");
		printArray(rotatedArray);
	}

	
	// Sub-Function
	public static int[][] rotateArrayRight(int[][] Array) {

		int totalRowsOfRotatedArray = Array[0].length; // Total rows of Original Array
		int totalColsOfRotatedArray = Array.length; // Total columns of Original Array

		// create empty Array with original size
		int[][] rotatedArray = new int[totalRowsOfRotatedArray][totalColsOfRotatedArray];
		
		
		for (int i = 0; i < Array.length; i++) { //Iterate over array (Rows)
			
			for (int j = 0; j < Array[0].length; j++) { //Iterate over array (Columns)
				
				// Swap Columns and Rows
				rotatedArray[j][(totalColsOfRotatedArray - 1) - i] = Array[i][j];
			}
		}
		return rotatedArray;
	}

	
	// Sub-Function
	public static int[][] rotateArrayLeft(int[][] Array) {

		int totalRowsOfRotatedArray = Array[0].length; // Total columns of Original Array
		int totalColsOfRotatedArray = Array.length; // Total rows of Original Array

		int[][] rotatedArray = new int[totalRowsOfRotatedArray][totalColsOfRotatedArray];

		for (int i = 0; i < Array.length; i++) {
			for (int j = 0; j < Array[0].length; j++) {
				
				// Swap Columns and Rows
				rotatedArray[(totalRowsOfRotatedArray - 1) - j][i] = Array[i][j];
			}
		}
		return rotatedArray;
	}

}