package A22;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AgeCalculatorComplicated {

	public static void main(String[] args) {

		System.out.println(gibAlter(4, 8, 2003));

	}

	public static boolean schaltjahr(int iJahr) {

		boolean temp = false;

		if (iJahr % 4 == 0) {
			if (iJahr % 100 == 0) {
				if (iJahr % 400 == 0) {
					temp = true;
				}
			} else {
				temp = true;
			}
		}

		return temp;
	}

	private static int gibAlter(int pTag, int pMonat, int pJahr) {

		Calendar cal = new GregorianCalendar();

		int gebjahr = pJahr;
		int gebmonat = pMonat;
		int gebtag = pTag;

		// Aktuelles Datum
		Calendar calHeute = new GregorianCalendar();
		int jahr = calHeute.get(Calendar.YEAR);
		int monat = calHeute.get(Calendar.MONTH)+1;
		int tag = calHeute.get(Calendar.DAY_OF_MONTH);

		
		if (monat >= gebmonat) { 					// Jahr berechnen
			if(tag>=gebtag)
				System.out.println(jahr - gebjahr);
			else if(monat==gebmonat&&tag<gebtag)
				System.out.println(jahr-gebjahr-1);
			else
				System.out.println(jahr - gebjahr);
			
		} else {
			System.out.println(jahr - gebjahr-1);
		}

		if (tag <= gebtag) {						//Monat
			if((monat-gebmonat-1)<0)
				System.out.println(12+(monat - gebmonat-1));
			else
				System.out.println(monat-gebmonat-1);
		} else {
			if((monat-gebmonat)<0)
				System.out.println(12+(monat - gebmonat));
			else
				System.out.println(monat-gebmonat);
		}
		
			if (monat % 2 == 0 && monat != 2) {		//30Tage Monat
				tag += (30 - gebtag);
				System.out.println(tag);

			} else if (monat == 2) {			
				if (schaltjahr(jahr) == true) {		//Schaltjahr Februar
					tag += (29 - gebtag);
					System.out.println(tag);
				} else if (schaltjahr(jahr) == false) { //kein Schaltjahr Februar
					tag += (28 - gebtag);
					System.out.println(tag);
				}
			} else {									//31 Tage Monat
				tag += (31 - gebtag)-1;
				if(tag>31)
					System.out.println(tag-30);
				else
					System.out.println(tag);
			}


		return 0;
	}

}
