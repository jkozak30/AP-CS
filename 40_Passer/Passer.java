public class Passer {
	public static int varChange(int x) {
		x += 10;
		return x;
	}
	
	public static String varChange(String x) {
		x = "";
		return x;
	}
	
	public static boolean varChange(boolean x) {
		if (x) {
			x = false;
		} else {
			x = true;
		}
		return x;
	}
	
	public static void main(String[] args) {
		int a = 4;
		System.out.println("value of a: " + a);
		int checkA = a;
		System.out.println("output of varChange: " + varChange(a));
		System.out.println("new value of a: " + a);
		if (checkA == a) {
			System.out.println("java is pass-by-value.");
		} else {
			System.out.println("java is pass-by-reference.");
		}
		System.out.println();
		
		String b = "hello";
		System.out.println("value of b: " + b);
		String checkB = b;
		System.out.println("output of varChange: " + varChange(b));
		System.out.println("new value of b: " + b);
		if (checkB.equals(b)) {
			System.out.println("java is pass-by-value.");
		} else {
			System.out.println("java is pass-by-reference.");
		}
		System.out.println();
		
		boolean c = false;
		System.out.println("value of c: " + c);
		boolean checkC = c;
		System.out.println("output of varChange: " + varChange(c));
		System.out.println("new value of c: " + c);
		if ((c && checkC) || (!c && !checkC)) {
			System.out.println("java is pass-by-value.");
		} else {
			System.out.println("java is pass-by-reference.");
		}
		
	}
}
