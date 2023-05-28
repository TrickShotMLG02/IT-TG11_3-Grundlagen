package A13_ReadingNumbers;

public class ReadingNumbers {

	static int code = 123456;
	
	public static void main(String[] args) {
		
		// String Conversion (Dynamic)
		System.out.println("Erste ziffer: " + String.valueOf(code).charAt(0) + "\nLetzte Ziffer: " + String.valueOf(code).charAt(String.valueOf(code).length()-1) + "\n\n");
		
		// Math Calculation (Dynamic)
		int firstDigit = (int) (code / Math.pow(10, String.valueOf(code).length()-1));
		int lastDigit = code % 10;		
		
		System.out.println("Erste Ziffer: " + firstDigit);
		System.out.println("Letzte Ziffer: " + lastDigit);		
	}

}
