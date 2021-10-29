public class String2.java {
	public String doubleChar(String str) {
		String result = "";
		int length = str.length();
		for (int n = 0; n < length; n++) {
			result = result + str.substring(n, n+1) + str.substring(n, n+1);
		}
		return result;
	}

	public int countHi(String str) {
		int result = 0;
		int length = str.length();
		for (int n = 0; n < length-1; n++) {
			if (str.substring(n, n+2) == "hi") {
				result = result + 1;
			}
		}
		return result;
	}
}
