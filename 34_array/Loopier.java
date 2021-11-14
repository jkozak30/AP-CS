// Team Orange Marshmallows: Julia Kozak, Diana Akhmedova, Nina Jiang (Flopsy, Ajax, Miss Alpaca)
// APCS
// HW34 -- A Pirate's Life for Me
// 2021-11-13
// Time Spent: 2.2 hours

/*
DISCO: When finding the length of an array (arr), use arr.length , no parentheses
       To return an array in a method, write it like any other data type (ex. int[] )
QCC: Is it possible to make a recursive linear search algo without a third parameter?
*/

public class Loopier {

	public static void setArray( int[] a ) {
		int length = a.length;
		double max = Math.pow(2, 31);
		for ( int i = 0; i < length; i++) {
			double sign = Math.random();
			if (sign < 0.5) {
				sign = 1;
			} else {
				sign = -1;
			}
			int random = (int)(Math.floor(Math.random() * sign * max));
			a[i] = random;
		}
	}

	//for easier testing, sets min/max integers for range
	public static void setArrayRange ( int[] a ) {
		int length = a.length;
		int max = 1000;
		int min = 0;
		for (int i = 0; i < length; i++) {
			a[i] = (int)(Math.floor(Math.random() * (max-min+1) + min));
		}
	}

	//allows recursive methods, returns rest of an array from a certain index
	public static int[] restOfArr(int[] a, int fromIndex) {
		int[] ret = new int[a.length-fromIndex];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = a[fromIndex + i];
		}
		return ret;
	}

	public static String printArray ( int[] a ) {
		String ans = "{ ";
		for (int i = 0; i < a.length-1; i++) {
			ans = ans + a[i] + ", ";
		}
		ans = ans + a[a.length-1];
		ans = ans + " }";
		return ans;
	}

	public static int linSearch( int[] a, int target ) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == target) {
				return i;
			}
		}
		return -1;
	}

	//note third parameter must always be 0 to start from the first index
	public static int linSearchR( int[] a, int target, int i ) {
		if (i == a.length) {
			return -1;
		} else if (a[i] == target) {
			return i;
		} else {
			return linSearchR(a, target, i+1);
		}
	}
	public static int freq( int[] a, int target ) {
		int freqCtr = 0;
		for (int s : a) {
			if (s == target) {
				freqCtr +=1;
			}
		}
		return freqCtr;
	}

	public static int freqRec( int[] a, int target ) {
		if (a.length == 1) {
			if (a[0] == target) {
				return 1;
			} else {
				return 0;
			}
		} else {
			if (a[0] == target) {
				return 1 + freqRec(restOfArr(a, 1), target);
			} else {
				return freqRec(restOfArr(a, 1), target);
			}
		}
	}

	public static void main(String[] args) {
		int target = (int)(Math.random() * 1000);
		int[] list = new int[400];
		setArrayRange(list);
		System.out.println("Target: " + target);
		System.out.println(printArray(list));
		System.out.println("Linear Search: " + linSearchR(list, target, 0));
		System.out.println("Frequency: " + freq(list, target));
	}
}

