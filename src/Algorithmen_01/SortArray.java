package Algorithmen_01;

public class SortArray {

	public static void main(String[] args) {

		int[] array = { 17, 1, 9, 13, 5 };

		array = insertionSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static int[] minimumSortSwitch(int[] array) {
		int temp;

		for (int i = 1; i < array.length; i++) {
			for (int t = i; t > 0; t--) {
				if (array[t] < array[t - 1]) {
					temp = array[t]; // save value from current position to "temp"

					array[t] = array[t - 1]; // saving value of previous index to current position
					array[t - 1] = temp; // saving value from "temp" to previous index
				}
			}
		}
		return array;
	}

	public static int[] insertionSort(int[] array) {
		
		int temp;
		
		for (int i = 1; i < array.length; i++) {
			
			temp = array[i];
			int t = i;
			
			while (t > 0 && array[t - 1] > temp) {
				array[t] = array[t - 1];
				System.out.println("t: " + t);
				t--;
			}
			
			for (int z = 0; z < array.length; z++) {
				System.out.println(array[z]);
			}
			System.out.println("t: " + t);
			System.out.println("merke: " + temp + "\n");
			
			array[t] = temp;			
			
		}
		
		return array;
	}
}