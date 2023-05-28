package A14_Skat;

public class Cardgame {

	public static String[] cardCollection = new String[32];
	
	public static void main(String[] args) {		
		
		GenerateCards();		
		cardCollection = RandomizeCards(cardCollection);		
		print(giveCards(10, cardCollection));				
	}
	
	public static void GenerateCards()
	{
		int counter = 7;
		for (int i = 0; i < cardCollection.length / 4; i++) {			
			cardCollection[i+0] = "Herz " + counter;						
			counter ++;			
		}
		counter = 7;
		for (int i = cardCollection.length / 4; i < cardCollection.length / 4 * 2; i++) {			
			cardCollection[i+0] = "Karo " + counter;						
			counter ++;			
		}
		counter = 7;
		for (int i = cardCollection.length / 4 * 2; i < cardCollection.length / 4 * 3; i++) {			
			cardCollection[i+0] = "Kreuz " + counter;						
			counter ++;			
		}
		counter = 7;
		for (int i = cardCollection.length / 4 * 3; i < cardCollection.length / 4 * 4; i++) {			
			cardCollection[i+0] = "Pik " + counter;						
			counter ++;			
		}
		
		
		for (int i = 0; i < cardCollection.length; i++) {
			if (cardCollection[i].contains("11"))
			{
				if (cardCollection[i].contains("Herz"))
				{
					cardCollection[i]= "Herz Bube";
				}
				if (cardCollection[i].contains("Karo"))
				{
					cardCollection[i]= "Karo Bube";
				}
				if (cardCollection[i].contains("Kreuz"))
				{
					cardCollection[i]= "Kreuz Bube";
				}
				if (cardCollection[i].contains("Pik"))
				{
					cardCollection[i]= "Pik Bube";
				}
			}		
			if (cardCollection[i].contains("12"))
			{
				if (cardCollection[i].contains("Herz"))
				{
					cardCollection[i]= "Herz Dame";
				}
				if (cardCollection[i].contains("Karo"))
				{
					cardCollection[i]= "Karo Dame";
				}
				if (cardCollection[i].contains("Kreuz"))
				{
					cardCollection[i]= "Kreuz Dame";
				}
				if (cardCollection[i].contains("Pik"))
				{
					cardCollection[i]= "Pik Dame";
				}
			}			
			if (cardCollection[i].contains("13"))
			{
				if (cardCollection[i].contains("Herz"))
				{
					cardCollection[i]= "Herz König";
				}
				if (cardCollection[i].contains("Karo"))
				{
					cardCollection[i]= "Karo König";
				}
				if (cardCollection[i].contains("Kreuz"))
				{
					cardCollection[i]= "Kreuz König";
				}
				if (cardCollection[i].contains("Pik"))
				{
					cardCollection[i]= "Pik König";
				}
			}
			if (cardCollection[i].contains("14"))
			{
				if (cardCollection[i].contains("Herz"))
				{
					cardCollection[i]= "Herz Ass";
				}
				if (cardCollection[i].contains("Karo"))
				{
					cardCollection[i]= "Karo Ass";
				}
				if (cardCollection[i].contains("Kreuz"))
				{
					cardCollection[i]= "Kreuz Ass";
				}
				if (cardCollection[i].contains("Pik"))
				{
					cardCollection[i]= "Pik Ass";
				}
			}
		}
	}

	public static String[] RandomizeCards(String[] arr)
	{
		String[] randomized = new String[arr.length];
		
		for (int i = 0; i < randomized.length; i++) {
			int rnd = (int) ( Math.random () * 32 + 1);
			
			if (randomized[rnd-1] == null)
			{
				randomized[rnd-1] = arr[i];
			}
			else			
			{
				boolean skip = true;
				while (skip)
				{
					if (randomized[rnd-1] != null)
					{
						rnd = (int) ( Math.random () * 32 + 1);
					}
					else if (randomized[rnd-1] == null)
					{
						randomized[rnd-1] = arr[i];
						skip = false;
					}
				}
			}
		}		
		return randomized;
	}

	public static String[][] giveCards(int anzahlKarten, String[] arr)
	{
		String[][] gameCards = new String[anzahlKarten][3];
		
		int counter = 0;
		
		for (int i = 0; i < anzahlKarten; i++) {
			gameCards[i][0] = arr[counter];
			counter++;
		}
		for (int i = 0; i < anzahlKarten; i++) {
			gameCards[i][1] = arr[counter];
			counter++;
		}
		for (int i = 0; i < anzahlKarten; i++) {
			gameCards[i][2] = arr[counter];
			counter++;
		}
		
		return gameCards;
	}

	public static void print(String[][] gameDeck)
	{
		for (int i = 0; i < 3; i++) {
			System.out.println("\n\nSpieler " + (i+1));
			for (int j = 0; j < 10; j++) {
				System.out.println(gameDeck[j][i]);
			}						
		}
	}
}