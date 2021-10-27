//Team Wires: Julia Kozak, Joshua Yagupsky, Abdullah Faruque
//APCS
//HW26 -- GCD Three Ways
//2021-10-28
//Time spent: 0.3hrs

/*
* DISCO: You can find the min of two numbers easily by taking their sum and subtracting the max. This avoids having to create a minimum method.
* QCC: Is there an easy way to "swap" the values of two variables without creating a helper variable?
* ALGO:
* 1) Sort the numbers so that the first one is the larger of the two.
* 2) If these numbers are multiples of each other, than we are done, and we simply return the smaller of the two.
* 3) If they're not, we know that repeated subtraction preserves the gcd. So we can repeatedly subtract the smaller from the larger until the larger is no longer the larger. The quick way to do this is to use the modulo operator.
* 4) Using the old smaller number as the new larger and the modulo of the larger with the smaller as the new smaller, return to step 2.
*/

public class Stats {

  public static int gcd(int a, int b) {
    int i = b;
    while(!(a % i == 0 && b % i == 0)) {
      i-- ;
    }
    return i;
  }

  public static int gcdER(int a, int b) {
    int l = max(a, b);
    int s = a + b - l;
    if (l % s == 0) {
      return s;
    } else {
      return gcd(l%s, s);
    }
  }

  public static int gcdEW(int a, int b) {
    int l = max(a, b);
    int s = a + b - l;
    int e;
    while (l % s != 0) {
      e = l;
      l = s;
      s = e%s;
    }
    return s;
  }

/* alternatively

  public static int gcdEW2(int a, int b) {
    int l = max(a, b);
    int s = a + b - l;

    if (s == 0) {
      return l;
    }

    if (l == s) {
      return s;
    } else {
      while (l > s) {
        l = l - s;
      }
      return gcdEW2(l, s);
    }
  }

*/

  // main method
  public static void main(String[] args) {
    System.out.println(gcd(5,5));//Should return 5
    System.out.println(gcdER(5,5));
    System.out.println(gcdEW(5,5));
    System.out.println(gcd(5,10));//Should return 5
    System.out.println(gcdER(5,10));
    System.out.println(gcdEW(5,10));
    System.out.println(gcd(10,12));//Should return 2
    System.out.println(gcdER(10,12));
    System.out.println(gcdEW(10,12));
    System.out.println(gcd(100,8));//Should return 4
    System.out.println(gcdER(100,8));
    System.out.println(gcdEW(100,8));
  }
// used for maximum a and b
  public static int max(int a, int b) {
    if(a >= b) {
      return a;
    } else {
      return b;
    }
  }

}
