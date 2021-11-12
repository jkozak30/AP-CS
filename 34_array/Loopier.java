public class Loopier {
	public static void setArray( int[] a ) {
		int length = a.length();
		for ( int i = 0; i < length; i++) {
			
			int random = (int)(Math.random()*(Math.pow(2,31)));
			a[i] = random;
		}
	}
	
	public static String printArray ( int[] a ) {
		String ans = "{";
		for (int i = 0; i < a.length(); i++) {
			
		}
	}
	public static int linSearch( int[] a, int target ) {
		
	}
	public static int linSearchR( int[] a, int target ) {
		
	}
	public static int freq( int[] a, int target ) {
		
	}
}
