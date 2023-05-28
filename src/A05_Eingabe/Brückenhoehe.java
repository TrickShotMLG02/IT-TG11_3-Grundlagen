package A05_Eingabe;

import java.text.NumberFormat;
import java.util.Scanner;
import Interfaces.Physik;

public class Brückenhoehe implements Physik {

	// Expression s = 1/2 * g * t²

	public static double time;
	public static double height;
	
	static Scanner scanner = new Scanner(System.in);
	static double Input;
	static String InputAsString;
	static int DigitsToRound = 3;

	public static void main(String[] args) {

		Calculate();
	}
	
	static void Calculate()
	{
		NumberFormat formatter = NumberFormat.getInstance();
		formatter.setMaximumFractionDigits(DigitsToRound);	
		
		System.out.print("Geben sie die Zeit in Sekunden ein:\t");
				
		InputAsString = scanner.nextLine();
		
		boolean numeric = true;
        try {
            Input = Double.parseDouble(InputAsString);
        } catch (NumberFormatException e) {
            numeric = false;
        }
        	if(numeric)
        	{
        		// Input
        		time = Input;

        		// Process
        		height = 1f / 2 * EARTH_MAGNITUDE * time * time;
        		// Output        	       		
        		System.out.println("magnitude = " + formatter.format(EARTH_MAGNITUDE) + "m/s²");
        		System.out.println("estimated time = " + formatter.format(time) + "s");
        		System.out.println("height = " + formatter.format(height) + "m");
        		System.out.println("\n\n\n");
        	}	
        	
        // Loop	
        Calculate();
	}	
}