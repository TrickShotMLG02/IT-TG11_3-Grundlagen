package A03_Variablen;


public class Dreieck {
	
	public static double g;		
	public static double h;
	public static double area;
	
	
	//			   /|	
	//			  / |
	//		     /  |
	//		    /   |
	//		   /    |	h
	//		  /     |	
	//		 / area |
	//		/_______|
	//
	//			g
	
	
	public static void main(String[] args) {
		
		// Input
		g = 3;
		h = 5;
		
		
		// Processing		
		area = 0.5 * g * h;
		
		
		// Output		
		System.out.println("Grundseite g = " + g +  " cm" );
		System.out.println("Höhe h = " + h +  " cm" );
		System.out.println("Fläche area = " + area + " cm²");
		
		
	}
	
	
	
}
