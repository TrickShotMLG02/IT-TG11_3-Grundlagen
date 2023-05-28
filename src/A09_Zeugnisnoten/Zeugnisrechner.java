package A09_Zeugnisnoten;

public class Zeugnisrechner {
	
	public static double mark = 1;
	public static int roundedMark;
	public static String[] marks = { "Sehr Gut", "Gut", "Befriedigend", "Ausreichend", "Mangelhaft", "Ungenügend" };

	public static void main(String[] args) {
		roundedMark = (int) TrickShotAPI.util.Numerics().round(mark, 0);
		System.out.println(marks[roundedMark - 1]);
	}
	
}