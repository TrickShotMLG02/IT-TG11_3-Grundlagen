package Algorithmen_01;

public class HeronVerfahren {
	
	public static double result;
	
	public static void main(String[] args) {
		
		result = gibWurzel(2);		
	}
	
	public static double gibWurzel(double Zahl)
	{
		double[] values = new double[1000];
		values[0] = Zahl;
		
		for (int j = 0; j < values.length - 1; j++) {
			values[j+1] = 0.5 * (values[j] + Zahl / values[j]);
		}		
		return values[values.length - 1];		
	}
}