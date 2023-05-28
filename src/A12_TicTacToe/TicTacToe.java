package A12_TicTacToe;

public class TicTacToe {

	static int[][] spielstand;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		spielstand = new int[3][3];
		initGame();
		
	}
	
	public static void initGame()
	{
		for (int x = 0; x < spielstand.length; x++) {
			for (int y = 0; y < spielstand.length; y++) {			
				spielstand[x][y] = 0;				
			}
		}
	}
	
	public static void saveGameState()
	{
		
	}
	
	public static void CheckForWin()
	{
		
	}

}
