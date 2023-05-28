package Hausaufgaben;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class VideothekAltersüberprüfungGeburtsdatum {

	public static void main(String[] args) {

		Date curdate = new Date();
		Date birthDate = new Date();

		String strBirthdate = "";
		String strOut = "";

		int FSK = 0;

		System.out.println("Wann wurde der Kunde geboren?");

		Scanner scanner = new Scanner(System.in);
		strBirthdate = scanner.next();

		System.out.println("Mit welcher FSK ist der Film versehen? (FSK6, FSK12, FSK16, FSK18)");
		FSK = scanner.nextInt();
		scanner.close();

		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); // Geburtsdatum des Kunden (Format)

		try {
			birthDate = sdf.parse(strBirthdate);
			birthDate.setYear((birthDate.getYear() + FSK));
			
			if (birthDate.compareTo(curdate) <= 0) {
				strOut = "Der Kunde ist alt genug";
			} else {
				strOut = "Der Kunde ist nicht alt genug";
			}

			System.out.println(strOut);

		} catch (ParseException e) {
		}

	}

}
