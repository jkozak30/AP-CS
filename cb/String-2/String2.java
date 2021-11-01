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
			String nstring = str.substring(n, n+2);
			if(nstring.equals("hi")) {
				result = result + 1;
			}
		}
		return result;
	}
	
	public boolean catDog(String str) {
		int resultCat = 0;
		int resultDog = 0;
		int length = str.length();
		for (int n = 0; n < length-2; n++) {
			String nstring = str.substring(n, n+3);
			if (nstring.equals("cat")) {
				resultCat += 1;
			}
			if (nstring.equals("dog")) {
				resultDog += 1;
			}
		}
		return resultCat == resultDog;
	}
	
	public int countCode(String str) {
		int result = 0;
		int length = str.length();
		for(int n=0; n<length-3; n++) {
			String nstring = str.substring(n, n+2) + str.substring(n+3, n+4);
			if (nstring.equals("coe")) {
				result += 1;
			}
		}
		return result;
	}
	
	public boolean endOther(String a, String b) {
		int aLength = a.length();
		int bLength = b.length();
		if (aLength < bLength) {
			return endOther(b, a);
		} 
		String aLC = a.toLowerCase();
		String bLC = b.toLowerCase();
		String end = aLC.substring(aLength-bLength, aLength);
		if (end.equals(bLC)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean xyzThere(String str) {
		int length = str.length();
		int trueCtr = 0;
		if (length < 3) { 
			return false;
		} else {
			String bstring = str.substring(0, 3);
			if (bstring.equals("xyz")) {
				return true;
			} else {
				for (int n = 1; n<length-2; n++) {
					String anyXYZ = str.substring(n, n+3);
					String charBefore = str.substring(n-1, n);
					if (anyXYZ.equals("xyz") && !(charBefore.equals("."))) {
						return true;
					}
				} 
			}
		} return false;
	}
}
