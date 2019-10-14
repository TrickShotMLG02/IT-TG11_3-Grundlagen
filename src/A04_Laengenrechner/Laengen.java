package A04_Laengenrechner;

public class Laengen {

	/**
	 * @author Tim Schlachter TG11/3 14.10.2019
	 *
	 */
	
	public interface Length{
		
		double METER_IN_MILLIMETER = 1000;
		double METER_IN_CENTIMETER = 100;
		double METER_IN_METER = 1;
		double METER_IN_KILOMETER = 0.001;
		
		double METER_IN_FUSS = 0.3048;
		double METER_IN_YARDS = 3 * METER_IN_FUSS;
		double METER_IN_INCH = 39.3701;
		
		double METER_IN_SEEMEILEN = 1852;
		double METER_IN_MEILEN = 1609;
		
	}	
	
}
