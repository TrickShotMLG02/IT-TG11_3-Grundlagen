package Algorithmen_01;

public class QuickSort {

	public static void main(String[] args) {

		int[] i = { 2, 4, 1, 3, 6, 5 };

		System.out.println("sorted");
		TrickShotAPI.util.Arrays().printArray(TrickShotAPI.util.Arrays().convertToString(quickSort(i, 0, 5, true)));
		System.out.println("\nunsorted");
		TrickShotAPI.util.Arrays().printArray(TrickShotAPI.util.Arrays().convertToString(i));

	}

	public static int[] quickSort(int[] a, int min, int max, boolean firstRun) {

		if (firstRun) {
			int[] arr = a.clone();

			quickSort(arr, min, max, false);
			return arr;
		}
		int tmp = 0;
		int i = min;
		int j = max;

		int x = a[(min + max) / 2];

		do {
			while (a[i] < x) {
				i++;
			}
			while (a[j] > x) {
				j--;
			}

			if (i <= j) {
				tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				i++;
				j--;
			}
		} while (i <= j);

		if (min < j) {
			quickSort(a, min, j, false);
		}
		if (i < max) {
			quickSort(a, i, max, false);
		}

		return a;
	}
}
