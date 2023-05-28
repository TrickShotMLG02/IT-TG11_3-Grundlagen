package A10_GGT;

import java.util.Scanner;

public class GroessterGemeinsamerTeiler {

	public static void main(String[] args) {

		double num1 = 0;
		double num2 = 0;
		double div = 0;
		double smaller = 0;

		Scanner scanner = new Scanner(System.in);
		System.out.println("Bitte geben sie die erste Zahl ein");
		num1 = scanner.nextDouble();
		System.out.println("Bitte geben sie die zweite Zahl ein");
		num2 = scanner.nextDouble();

		if (num1 < num2) {
			smaller = num1;
		} else {
			smaller = num2;
		}

		for (int i = (int) smaller; i > 0; i--) {

			if (num1 % i == 0 && num2 % i == 0) {
				div = i;
				System.out.println("GGT von " + num1 + " und " + num2 + ": " + div);
				break;
			}
		}
		scanner.close();
	}
}