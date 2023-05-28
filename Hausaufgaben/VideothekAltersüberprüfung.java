package Hausaufgaben;

import java.util.Scanner;

public class VideothekAltersüberprüfung {

	public static void main(String[] args) {

		int age = 0;
		int FSK = 0;

		System.out.println("Wie alt ist der Kunde?");
		Scanner scanner = new Scanner(System.in);
		age = scanner.nextInt();

		System.out.println("Mit welcher FSK ist der Film versehen? (FSK6, FSK12, FSK16, FSK18)");
		FSK = scanner.nextInt();
		scanner.close();

		if (age < FSK) {
			System.out.println("Der Kunde ist zu jung für diesen Film!");
		} else {
			System.out.println("Der Kunde ist alt genug, um diesen Film auszuleihen!");
		}

	}

}
