package A05_Eingabe;

import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.util.Scanner;
import Interfaces.Laengen;


/**
 * @author Tim Schlachter TG11/3 14.10.2019
 *
 */



public class Laengenrechner_Console implements Laengen{

	static Scanner scanner = new Scanner(System.in);
	static double Input;
	static String InputAsString;
	static int DigitsToRound = 5;
	
	public static void main(String[] args) {
			
		Calculate();
		
        }  
	
	
	static void Calculate()
	{
		
		NumberFormat formatter = NumberFormat.getInstance();
		formatter.setMaximumFractionDigits(DigitsToRound);	
		
		System.out.print("Geben sie die Zahl zum Umrechnen in Metern ein:\t");
				
		InputAsString = scanner.nextLine();
		
		boolean numeric = true;
        try {
            Input = Double.parseDouble(InputAsString);
        } catch (NumberFormatException e) {
            numeric = false;
        }
        	if(numeric)
        	{
        	System.out.println(formatter.format(Input * METER_IN_MILLIMETER) + " Millimeter");
    		System.out.println(formatter.format(Input * METER_IN_CENTIMETER) + " Centimeter");		
    		System.out.println(formatter.format(Input * METER_IN_METER) + " Meter");
    		System.out.println(formatter.format(Input * METER_IN_KILOMETER) + " Kilometer");
    		System.out.println(formatter.format(Input / METER_IN_FUSS)+ " Fuss");
    		System.out.println(formatter.format(Input / METER_IN_YARDS)+ " Yards");
    		System.out.println(formatter.format(Input * METER_IN_INCH)+ " Inch");
    		System.out.println(formatter.format(Input / METER_IN_MEILEN)+ " Meilen");		
    		System.out.println(formatter.format(Input / METER_IN_SEEMEILEN)+ " Seemeilen");
    		System.out.println("\n\n\n");
        	}
        	else
        	{
        		System.out.println("Error\n\n\n");
        	}
        	
        	Calculate();
	}
}