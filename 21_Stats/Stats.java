/**
   Team Wires: Julia Kozak, Joshua Yagupsky, Abdullah Faruque
   APCS
   HW21 -- STAtisTically Speaking...
   2021-10-20
 **/

 /**
  DISCO: Math.pow and Math.sqrt return doubles, and Math.round returns a long
  QCC:
 **/

public class Stats {

  public static int mean(int a, int b) {
    int mean = a/2 + b/2;
    return mean;
  }

  public static double mean(double a, double b) {
    double mean = a/2.0 + b/2.0;
    return mean;
  }

  public static int max(int a, int b) {
    int max;
    if (a > b) {
      max = a;
    } else {
      max = b;
    }
    return max;
  }

  public static double max(double a, double b) {
    double max;
    if (a > b) {
      max = a;
    } else {
      max = b;
    }
    return max;
  }

  public static int geoMean(int a, int b) {
    int product = a * b;
    int geoMean = (int)Math.sqrt(product);
    return geoMean;
  }

  public static double geoMean(double a, double b) {
    double product = a * b;
    double geoMean = Math.sqrt(product);
    return geoMean;
  }

  public static int max(int a, int b, int c) {
    int max;
    if (a > b) {
      if (a > c) {
        max = a;
      } else {
        max = c;
      }
    } else {
      max = b;
    }
    return max;
  }

  public static double max(double a, double b, double c) {
    double max;
    if (a > b) {
      if (a > c) {
        max = a;
      } else {
        max = c;
      }
    } else {
      max = b;
    }
    return max;
  }

  public static int geoMean(int a, int b, int c) {
    int product = a * b * c;
    int geoMean = (int)Math.cbrt(product);
    return geoMean;
  }

  public static double geoMean(double a, double b, double c) {
    double product = a * b * c;
    return Math.cbrt(product);
  }

  public static double harmonicMean(double a, double b) {
    double sumReciprocals = 1/a + 1/b;
    return 2/sumReciprocals;
  }

  public static double harmonicMean(double a, double b, double c) {
    double sumReciprocals = 1/a + 1/b + 1/c;
    return 3/sumReciprocals;
  }


  //main method for testing functionality
  public static void main( String[] args ) {

  }

}//end class
