package A11_Login;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		String usrString = "Test";
		String psswdString = "LOL";
		
		String usr;
		String psswd;
		
		String MSG = "";
		
		int counter = 0;
		boolean extend = false;
		
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("Benutzername:\t");
			usr = scanner.next();
			System.out.print("Passwort:\t");
			psswd = scanner.next();
			
			if(!(usrString.equals(usr) && psswdString.equals(psswd)))
			{
				MSG = "Login Fehlgeschlagen";
				counter++;
				if (counter > 3)
				{
					System.out.println(counter + " Sekunden warten");
					Wait(counter);
				}
			}		
			else {
				MSG = "Login erfolgreich";
			}
		} while (!(usrString.equals(usr) && psswdString.equals(psswd)));
		
		System.out.println(MSG);
	}

	public static void Wait(int count)
	{
		try {
			for (int i = count; i > 0; i--) {
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
		}
	}
	
}
