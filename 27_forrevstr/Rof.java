//Julia Kozak, John Gupta-She, Ziying Jian
//APCS
//HW27 -- FOR the Love of Strings
//2021-10-29
//Time spent: 0.3hrs

/*
DISCO: you have to initialize the value of a string to include it in the update of its value (ex. result = result + <something> won't work otherwise)
       String.substring(firstIndex, lastIndex) does not include the character of index lastIndex
QCC: 
*/

public class Rof {

  public static String fenceF(int posts) {
    String result = "|";
    for (int n = 1; n < posts; n++) {
      result = result + "--|";
    }
    return result;
  }

  public static String reverseF(String s) {
    String result = "";
    int length = s.length();
    for (int n = length; n > 0; n--) {
      result = result + s.substring(n-1, n);
    }
    return result;
  }

  public static String reverseR(String s) {
    String result = "";
    int length = s.length();
    if (length == 0) {
      return result;
    } else {
      return s.substring(length-1, length) + reverseR(s.substring(0, length-1));
    }
  }

  public static void main(String[] args) {
    System.out.println(fenceF(3));
    System.out.println(fenceF(1));
    System.out.println(fenceF(6));
    System.out.println(reverseF("yes"));
    System.out.println(reverseF("2003"));
    System.out.println(reverseR("sdrawkcab tnirp lliw siht"));
    System.out.println(reverseR("flopsy"));
  }

}
