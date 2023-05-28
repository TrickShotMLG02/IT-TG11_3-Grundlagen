package Algorithmen_02;

public class TSP {

	public static final String[] LETTERS = { "A", "B", "C", "D", "E" };
	public static final int DASH = Integer.MAX_VALUE / 2;
	public static final int SIZE = 5;
	public static String connectionString = ""; 
	public static String uncodedConnectionString = "";
	
	
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
				matrix = minimizeRow(matrix, j, getMinimumOfRow(matrix, j));
			}
			for (int j = 0; j < matrix.length; j++) {
				matrix = minimizeCol(matrix, j, getMinimumOfCol(matrix, j));
			}
			
			
			// PENALTIES
			penalties = createMatrix(matrix.length);
			penalties = getPenaltiesOfRows(matrix, penalties);
			penalties = getPenaltiesOfColumns(matrix, penalties);			
			
			matrix = getHighestPenalty(matrix, penalties);

			// PRINT
			System.out.println("\nIteration: " + (i+1));		
			System.out.println("PEMNALTIES");
			printArray(penalties);
			System.out.println("MATRIX");
			printArray(matrix);
			
			minimizeMatrix(matrix, penalties);
			
			//System.out.println(connectionString);
		}
		
		System.out.println(connectionString);
		
	}
	
	public static int[][] getHighestPenalty(int[][] matrix, int[][] penalties)
	{
		int tempPenalty = 0;
		int tempCol = 0;
		int tempRow = 0;
	
		
	for (int col = 0; col < matrix.length; col++) {
			for (int row = 0; row < matrix.length; row++) {
				
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
		
		//connectionString += connectionManager(tempCol, tempRow, LETTERS);
		
		return matrix;
	}
	
	public static int[][] getPenaltiesOfColumns(int[][] matrix, int[][] penalties)
	{
		int min1;
		int min1Col;
		int min2;

		for (int spalte = 0; spalte < matrix.length; spalte++) {
			min1 = DASH;
			min1Col = -1;
			min2 = DASH;
			
			for (int reihe = 0; reihe < matrix.length; reihe++) {
				if (matrix[reihe][spalte] < min1) {
					min1 = matrix[reihe][spalte];
					min1Col = reihe;
				}
			}
			
			for (int reihe = 0; reihe < matrix.length; reihe++) {
				//if (matrix[reihe][spalte] < min2 && reihe != min1Col) {
				if (matrix[reihe][spalte] < min2 && reihe != min1Col) {
					min2 = matrix[reihe][spalte];
				}
			}
			
			if (min1 == 0) {
				penalties[min1Col][spalte] = penalties[min1Col][spalte] + min2;
			}
		}
		return penalties;
	}
	public static int[][] getPenaltiesOfRows(int[][] matrix, int[][] penalties)
	{
		int min1;
		int min1Row;
		int min2;

		for (int reihe = 0; reihe < matrix.length; reihe++) {
			min1 = DASH;
			min1Row = -1;
			min2 = DASH;
			
			for (int spalte = 0; spalte < matrix.length; spalte++) {
				if (matrix[reihe][spalte] < min1) {
					min1 = matrix[reihe][spalte];
					min1Row = spalte;
				}
			}
			
			for (int spalte = 0; spalte < matrix.length; spalte++) {
				//if (matrix[reihe][spalte] < min2) {
				if (matrix[reihe][spalte] < min2 && spalte != min1Row) {
					min2 = matrix[reihe][spalte];
				}
			}	
			if (min1 == 0) {
				penalties[reihe][min1Row] = min2;
			}
		}
		return penalties;
	}
	
	public static int[][] createMatrix(int length) {
		int[][] array = new int[length][length];
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				array[i][j] = 0;
			}
		}	
		return array;
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
		
		connectionString += connectionManager(maxPenaltyCol, maxPenaltyRow, LETTERS);
		uncodedConnectionString += uncodedConnectionManager(maxPenaltyCol, maxPenaltyRow, LETTERS);
		
		//System.out.println("maxCol: " + maxPenaltyCol + " maxRow: " + maxPenaltyRow + "\n");

		for (int i = 0; i < matrix.length; i++) {
			matrix[maxPenaltyCol][maxPenaltyRow] = DASH;
			matrix[maxPenaltyRow][i] = DASH;
		}
		matrix[maxPenaltyCol][maxPenaltyRow] = DASH;
	}
	
	public static int[][] minimizeRow(int[][] matrix, int row, int min)
	{
		//min = getMinimumOfRow(matrix, row);

		for (int j = 0; j < matrix.length; j++) {
			if (matrix[j][row] != DASH) {
				matrix[j][row] = matrix[j][row] - min;
			}
		}
		return matrix;
	}
	public static int getMinimumOfRow(int[][] matrix, int row) {
		int min = Integer.MAX_VALUE;
		
		for (int j = 0; j < matrix.length; j++) {
			if (matrix[j][row] < min) {
				min = matrix[j][row];
			}
		}
		return min;
	}
	
	public static int[][] minimizeCol(int[][] matrix, int col, int min)
	{		
		//min = getMinimumOfCol(matrix, col);

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[col][i] != DASH) {
				matrix[col][i] = matrix[col][i] - min;
			}
		}
		return matrix;
	}
	private static int getMinimumOfCol(int[][] matrix, int col) {
		int min = DASH;
		
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[col][i] < min) {
				min = matrix[col][i];		
			}
		}
		return min;
	}
	
	public static void printArray(int[][] array) {

		for (int i = 0; i < array.length; i++) {
			//System.out.print("\t" + LETTERS[i]);
			System.out.print("\t" + getLetter(i));
		}

		for (int i = 0; i < array.length; i++) {
			System.out.println();
			//System.out.print(LETTERS[i] + " ");
			System.out.print(getLetter(i) + " ");
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
	
	public static String connectionManager(int col, int row, String[] letters) {
		//return (letters[row] + ">" + letters[col] + " ");
		return (getLetter(row) + ">" + getLetter(col) + " ");
	}	
	public static String uncodedConnectionManager(int col, int row, String[] letters) {
		return ((row+1) + "" + (col+1));
	}

	
	public static String getLetter(int i)
	{
		
		return Character.toString(i<0 || i>25 ? '?' : (char)('A' + i));
	}
	
}