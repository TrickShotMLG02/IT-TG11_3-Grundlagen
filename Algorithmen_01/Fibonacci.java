package Algorithmen_01;

public class Fibonacci {

	public static void main(String[] args) {
		
		int count = 91;
		long calc[] = new long[3];
		calc[0] = 0;
		calc[1] = 1;

		System.out.println(calc[0]);
		System.out.println(calc[1]);
		
		for (int i = 0; i < count; i++) {
			calc[2] = calc[0] + calc[1];
			calc[0] = calc[1];
			calc[1] = calc[2];
			System.out.println(calc[2]);
		}
		
	}

}
