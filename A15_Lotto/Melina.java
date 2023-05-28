package A15_Lotto;

public class Melina {

	static int[] haeufigkeitLotto = new int[49];
    static int[] dieLottozahlen = new int[6];



    public static void main(String[] args) {
    	
        ausgabeLottozahlen(ziehe6aus49());
        int []sortiert= dieLottozahlen.clone();
        sortiert = quicksort(sortiert, 0, dieLottozahlen.length-1);
        ausgabeQuicksort(sortiert);
        
    }// end main
  

    public static int[] ziehe6aus49() {


        boolean[] gezogeneZahlen = new boolean[49];

        for (int i = 0; i < dieLottozahlen.length; i++) {
            do {
                // ziehe eine Zufallszahl zw. 1 und 49
                dieLottozahlen[i] = (int) (Math.random() * 49 + 1);
                
            } while (gezogeneZahlen[dieLottozahlen[i] - 1] == true);
            // Merke die gerade gezogene Zahl
            gezogeneZahlen[dieLottozahlen[i] - 1] = true;
        }// end for

        return dieLottozahlen;
    }
    
    public static int[] quicksort(int [] a, int oben, int unten) {
		int tmp;
		int i = unten;
		int j = oben;
		int x = a[(unten+oben)/2];
    	
    	do {
			
    		while (a[i]<x) {
				i++;
			}
    		while (a[j]>x) {
				j--;
			}
    		
    		if (i<=j) {
				tmp= a[i];
				a[i]= a[j];
				a[j]=tmp;
				i++;
				j--;
			}
		} while (i<=j);
    		if (unten<j) {
				quicksort(a, unten, j);
			}
    		if (i<oben) {
			quicksort(a, i, oben);
		}
    	
    	return a;
	}
    

    public static void ausgabeLottozahlen(int[] dieLottozahlen) {

        for (int i = 0; i < dieLottozahlen.length; i++) {
            System.out.print(dieLottozahlen[i]+" ");
        }

        System.out.println("SZ:"+gibSuperzahl());
    }

    public static int gibSuperzahl(){

        return (int) (Math.random()*9+1);

    }
    
    public static void ausgabeQuicksort(int dieLottozahlen[]) {
		
    	for (int i = 0; i < dieLottozahlen.length; i++) {
    		if (i < dieLottozahlen.length - 1) {
                System.out.print(dieLottozahlen[i] + ", ");

            } else {
                System.out.print(dieLottozahlen[i]);
            }

        }
	}
}