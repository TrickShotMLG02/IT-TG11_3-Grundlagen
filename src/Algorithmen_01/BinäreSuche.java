package Algorithmen_01;

public class BinäreSuche {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public int binaereSuche(int[] a, int x)
	{
		int k;
		int i = 0;
		int j = a.length - 1;
		
		while (i <= j) {
			k = (i + j) / 2;
			
			if ( a[k] == x)
			{
				return k;
			}
			if (x < a[k])
			{
				j = k - 1;
			}
			else {
				i = k + 1;
			}
		}
		return -1;
	}
	
	public int sequenzielleSuche(int[] a, int x)
	{
		int k = 0;
		while (k < a.length) {
			if (a[k] == x)
			{
				return k;
			}
			k++;
		}
		return -1;
	}

}
