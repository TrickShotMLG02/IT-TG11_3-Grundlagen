package Algorithmen_02;

public class TravellingSalesmanProblem {

	public static final int DASH = Integer.MAX_VALUE;
	public static final String[] LETTERS = {"A", "B", "C", "D", "E"};
	
	public static String connectionString = "";
	
	public static void main(String[] args) {

		int[][] matrix = {
				{ DASH, 5, 3, 2, 4 },
				{ 5, DASH, 4, 1, 7 },
				{ 3, 4, DASH, 2, 2 },
				{ 2, 1, 2, DASH, 3 },
				{ 4, 7, 2, 3, DASH }
				};
		TSP(matrix);
		
	}
	
	public static void TSP(int[][] matrix)
	{
		int[][] penalties = createMatrix(matrix.length);
		for (int i = 0; i < matrix.length; i++) {		

			// MINIMIZING
			for (int j = 0; j < matrix.length; j++) {
				matrix = minimizeRow(matrix, j, getMinOfRow(matrix, j));
			}
			for (int j = 0; j < matrix.length; j++) {
				matrix = minimizeCol(matrix, j, getMinOfCol(matrix, j));
			}
			
			
			// PENALTIES
			penalties = createMatrix(matrix.length);
			penalties = getPenaltyOfRows(matrix, penalties);
			penalties = getPenaltyOfCols(matrix, penalties);			
			
			matrix = getHighestPenalty(matrix, penalties);

			// PRINT
			System.out.println("\nIteration: " + (i+1));		
			System.out.print("PEMNALTIES");
			printArray(penalties);
			System.out.print("MATRIX");
			printArray(matrix);
			
			minimizeMatrix(matrix, penalties);
		}
		
		System.out.println(connectionString);
	}

	public static void printArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println();
			for (int j = 0; j < array.length; j++) {

				if (array[j][i] == DASH) {
					System.out.print("\t-");
				} else {
					System.out.print("\t" + array[j][i]);
				}
			}
		}
		System.out.println("\n");
	}
	
	public static int getMinOfRow(int[][] matrix, int row) {
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[i][row] < min) {
				min = matrix[i][row];
			}
		}
		return min;
	}
	public static int[][] minimizeRow(int[][] matrix, int row, int min) {
		for (int j = 0; j < matrix.length; j++) {
			if (matrix[j][row] != DASH) {
				matrix[j][row] = matrix[j][row] - min;
			}
		}
		return matrix;
	}

	public static int getMinOfCol(int[][] matrix, int col) {
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[col][i] < min) {
				min = matrix[col][i];
			}
		}
		return min;
	}
	public static int[][] minimizeCol(int[][] matrix, int col, int min) {

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[col][i] != DASH) {
				matrix[col][i] = matrix[col][i] - min;
			}
		}
		return matrix;
	}

	
	public static int[][] getPenaltyOfCols(int[][] matrix, int[][] penalties) {
		
		int min1;
		int min1Col;
		int min2;

		for (int col = 0; col < matrix.length; col++) {

			min1 = DASH;
			min1Col = -1;
			min2 = DASH;

			for (int row = 0; row < matrix.length; row++) {
				if (matrix[row][col] < min1) {
					min1 = matrix[row][col];
					min1Col = row;
				}
			}

			for (int row = 0; row < matrix.length; row++) {
				if (matrix[row][col] < min2 && row != min1Col) {
					min2 = matrix[row][col];
				}
			}
			
			if (min1 == 0) {
				penalties[min1Col][col] = penalties[min1Col][col] + min2;
			}			
			//System.out.println(min1 + " " + min1Col + " " + min2);
		}

		return penalties;
	}
	public static int[][] getPenaltyOfRows(int[][] matrix, int[][] penalties) {

		int min1;
		int min1Row;
		int min2;

		for (int row = 0; row < matrix.length; row++) {
			min1 = DASH;
			min1Row = -1;
			min2 = DASH;

			for (int col = 0; col < matrix.length; col++) {
				if (matrix[row][col] < min1) {
					min1 = matrix[row][col];
					min1Row = col;
				}
			}

			for (int col = 0; col < matrix.length; col++) {
				if (matrix[row][col] < min2 && col != min1Row) {
					min2 = matrix[row][col];

				}
			}

			if (min1 == 0) {
				penalties[row][min1Row] = min2;

			}
		}
		return penalties;
	}

	public static int[][] getHighestPenalty(int[][] matrix, int[][] penalties)
	{
		int tempPenalty = 0;
		int tempCol = 0;
		int tempRow = 0;		
		
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix.length; col++) {
				
				if (matrix[col][row] == 0)
				{
					if (tempPenalty < penalties[col][row])
					{
						tempPenalty = penalties[col][row];
						tempCol = col;
						tempRow = row;
					}
				}				
			}			
		}
		
		for (int i = 0; i < matrix.length; i++) {
			matrix[tempCol][i] = DASH;
			matrix[i][tempRow] = DASH;
		}		
		matrix[tempRow][tempCol] = DASH;	
		//connectionString += connectionManager(tempCol, tempRow);
		
		return matrix;
	}
	
	public static int[][] createMatrix(int length) {
		int[][] matrix = new int[length][length];

		return matrix;
	}
	public static void minimizeMatrix(int[][] matrix, int[][] penalties)
	{
		int max = 0;

		int maxPenaltyCol = -1;
		int maxPenaltyRow = -1;

		for (int reihe = 0; reihe < penalties.length; reihe++) {
			for (int spalte = 0; spalte < penalties.length; spalte++) {
				if (penalties[reihe][spalte] > max) {
					max = penalties[reihe][spalte];
					maxPenaltyCol = spalte;
					maxPenaltyRow = reihe;
				}
			}
		}
		
		connectionString += connectionManager(maxPenaltyCol, maxPenaltyRow);
		
		System.out.println("maxCol: " + maxPenaltyCol + " maxRow: " + maxPenaltyRow + "\n");

		for (int i = 0; i < matrix.length; i++) {
			matrix[i][maxPenaltyCol] = DASH;
			matrix[maxPenaltyRow][i] = DASH;
		}
		matrix[maxPenaltyCol][maxPenaltyRow] = DASH;
	}
	
	public static String connectionManager(int col, int row)
	{	
		return (LETTERS[row] + ">" + LETTERS[col] + " ");
	}
}
