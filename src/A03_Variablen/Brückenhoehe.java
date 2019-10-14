package A03_Variablen;

public class Brückenhoehe {

	// Expression s = 1/2 * g * t²

	public static double time;
	public static double height;
	public static double magnitude = 9.806;

	public static void main(String[] args) {

		// Input

		time = 2.3;

		// Process

		height = 1f / 2 * magnitude * time * time;

		// Output

		System.out.println("magnitude = " + magnitude + "m/s²");
		System.out.println("estimated time = " + time + "s");
		System.out.println("height = " + height + "m");

	}

}