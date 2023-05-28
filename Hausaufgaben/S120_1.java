package Hausaufgaben;

public class S120_1 {

	public static void main(String[] args) {
		
		int[] zahlen = {5,78,23,1,12,2};
		
		double[] res = Calc(zahlen);
		
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
		
	}
	
	public static double[] Calc(int[] array)
	{
		double[] result = new double[4];
		//[0] = Minimum
		//[1] = Maximum
		//[2] = Summe
		//[3] = Mittelwert
		
		int sum = 0;
		
		array = TrickShotAPI.util.Arrays().sort(array);
		
		result[0] = array[0];
		result[1] = array[array.length - 1];
		
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		
		result[2] = sum;
		result[3] = (double)sum / array.length;
	
		
		return result;		
	}
}
