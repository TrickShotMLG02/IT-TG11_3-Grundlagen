package Algorithmen_01;

public class QuadraticEquationSolver {

	public static boolean usePQ = true;

	public static void main(String[] args) {

		// Input must be ( +/- "Value"x^y ... +/- "Value"x +/- "Value" = +/- "Value")
		Calc("+3.0x^2+2.0x-5.0=+2.0");
	}

	public static void Calc(String equationString) {
		String[][] splittedEquationArray = new String[3][5]; 						// | x^2 | x^1 | n |
		Character[] equationCharacters = new Character[equationString.length()];	// |	 |     |   |
		
		for (int i = 0; i < equationString.length(); i++) {
			equationCharacters[i] = equationString.charAt(i);
		}

		double[] valuesForCalculation = new double[4];

		double a = 0;
		double b = 0;
		double c = 0;
		double d = 0;

		String tempOperator = "";
		String tempNumberDigits = "";
		String tempNumberString = "";
		String finalNumberString = "";
		double number = 0;

		int counter = 0;
		int arrayCounter = 0;

		for (int i = 0; i < equationCharacters.length; i++) {

			if (isOperator(Character.toString(equationCharacters[i])) != "ERROR") {
				tempOperator = isOperator(Character.toString(equationCharacters[i]));
			}

			if (Character.toString(equationCharacters[i]).contains(".")) {
				tempNumberDigits += Character.toString(equationCharacters[i]);
				counter = i;

				// Get Digits of the number
				try {
					while (isNumeric(Character.toString(equationCharacters[counter + 1]))) {
						tempNumberDigits += Character.toString(equationCharacters[counter + 1]);
						counter++;
					}
				} catch (Exception e1) {
				}

				try {
					if (i - 1 >= 0) {
						counter = i - 1;
					}

					while (isNumeric(Character.toString(equationCharacters[counter]))) {
						tempNumberString += Character.toString(equationCharacters[counter]);
						counter--;
					}
				} catch (Exception e) {
				}

				finalNumberString = tempNumberString + tempNumberDigits;

				if (tempOperator.contains("-")) {
					number = Double.parseDouble(finalNumberString) * -1;
				} else {
					number = Double.parseDouble(finalNumberString);
				}

				valuesForCalculation[arrayCounter] = number;
				arrayCounter++;

				tempNumberDigits = "";
				tempNumberString = "";
				finalNumberString = "";
			}
		}

		a = valuesForCalculation[0];
		b = valuesForCalculation[1];
		c = valuesForCalculation[2];
		d = valuesForCalculation[3];

		if (d != 0) {
			c = c - d;
			d = 0;
		}

		if (usePQ) {

			// Normalisierung
			if (a >= 1) {
				double divider = a;
				a = a / divider;
				b = b / divider;
				c = c / divider;
				d = d / divider;
			} else {
				double multiplier = Math.pow(a, -1);

				a = a * multiplier;
				b = b * multiplier;
				c = c * multiplier;
				d = d * multiplier;
			}
			
			System.out.println("-- PQ-Formel --\n");
			
			System.out.println("--- Werte ---");
			System.out.println("p:" + b + " q:" + c + "\n");
			System.out.println("--- Lösung ---");
			
			// PQ-Formel
			d = Math.sqrt((Math.pow(((b / 2)), 2)) - c);

			if (d > 0) // Zwei Lösungen
			{
				double x1 = ((-b / 2) + d);
				double x2 = ((-b / 2) - d);			
				System.out.println("x1: " + x1 + "\nx2: " + x2);
			} else if (d == 0) // Eine Lösung
			{
				double x1 = ((-b / 2) + d);
				System.out.println("x1: " + x1);
			} else { // Keine Lösung
				System.out.println("Komplexe Lösung, da die Diskriminante d=" + d + " nicht definiert ist, da sie kleiner als 0 ist.");
			}

		} else {

			// Mitternachtsformel

			System.out.println("-- ABC-Formel --\n");
			System.out.println("--- Werte ---");
			System.out.println("a:" + a + " b:" + b + " c:" + c + "\n");
			System.out.println("--- Lösung ---");

			d = (Math.pow(b, 2) - (4 * a * c));

			if (d < 0) {

				//Calculate imaginary Number
				d = -d;
				double ans = Math.pow(d, 0.5);
				System.out.println("Komplexe Lösung, da die Diskriminante d=" + (-d) + " kleiner als 0 ist. \nImaginäre Diskriminante: " + ans + "i");
			} else if (d == 0) {
				double x1 = -b / (2 * a);

				System.out.println("x1: " + x1);
			} else {
				double x1 = (-b + Math.sqrt(d)) / (2 * a);
				double x2 = (-b - Math.sqrt(d)) / (2 * a);

				System.out.println("x1: " + x1 + "\nx2: " + x2);
			}
		}

	}

	public static boolean isNumeric(String value) {
		try {
			double d = Double.parseDouble(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static String isOperator(String string) {
		if (string.contains("-")) {
			return string;
		} else if (string.contains("+")) {
			return string;
		} else {
			return "ERROR";
		}
	}

	
}
