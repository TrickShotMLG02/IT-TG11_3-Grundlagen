package A02_Ausgaben;

public class Ausgabe {

	public static String name = "Tim Schlachter";
	public static String address = "Toggenburgstrasse 32";
	public static int zipCode = 8245;
	public static String StringBuilder = "";

	
	public static int[] x2 = new int[20]; // Array to save result of the quadratic evaluation
	public static int[] x3 = new int[20]; // Array to save result of the exponential evaluation

	
	public static void main(String[] args) {

		Calc();

	}

	static void Builder() {
		StringBuilder += name;
		StringBuilder += "\n";
		StringBuilder += address;
		StringBuilder += "\n";
		StringBuilder += zipCode;

		System.out.println(StringBuilder);

	}

	static void Table() {

		System.out.println("Name" + "\t\t" + "Vorname" + "\t\t" + "Emailadresse");
		System.out.println("Schlachter" + "\t" + "Tim" + "\t\t" + "tim.schlachter@shinternet.ch");
		System.out.println("Weggler" + "\t\t" + "Michael" + "\t\t" + "mweggler@gmail.com");
		System.out.println("Gut" + "\t\t" + "Maximilian" + "\t" + "mgut@icloud.com");
	}

	static void Calc() {

		for (int i = 0; i < x2.length; i++) {
			x2[i] = i * i;
		}

		for (int i = 0; i < x3.length; i++) {
			x3[i] = i * i * i;
		}

		for (int i = 0; i < x2.length; i++) {
			System.out.println(String.format("%05d", x2[i]) + "\t" + String.format("%05d", x3[i]));
		}

	}

}