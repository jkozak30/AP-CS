public class array2 {

  public static String arrToString( int[] ary ) {
    String ans = "[";
    for( int i = 0; i < ary.length; i++ ) {
      ans += ary[i];
      if( i != ary.length - 1 ) {
        ans += ", ";
      }
    }
    return ans + "]";
  }

  public static String arrToString( String[] ary ) {
    String ans = "[";
    for( int i = 0; i < ary.length; i++ ) {
      ans += ary[i];
      if( i != ary.length - 1 ) {
        ans += ", ";
      }
    }
    return ans + "]";
  }

  public static int countEvens(int[] nums) {
    int counter = 0;
    for (int i=0; i<nums.length; i++) {
      if (nums[i] % 2 == 0) {
        counter++;
      }
    }
    return counter;
  }

  public static int bigDiff(int[] nums) {
    int min = nums[0];
    int max = nums[0];
    for(int a : nums) {
      if (a < min) {
        min = a;
      }
      if (a > max) {
        max = a;
      }
    }
    return max-min;
  }

  public static int centeredAverage(int[] nums) {
    int max = nums[0];
    int min = nums[0];
    int sum = 0;
    for (int a : nums) {
      if (a < min) {
        min = a;
      }
      if (a > max) {
        max = a;
      }
      sum += a;
    }
    return (sum-max-min)/(nums.length-2);
  }

  public static int sum13(int[] nums) {
    int sum = 0;
    if (nums.length == 0) {
      return 0;
    }
    for (int i=0; i<nums.length-1; i++) {
      if (nums[i] == 13 && nums[i+1] !=13) {
        sum -= nums[i+1];
      } else if (nums[i] != 13) {
        sum += nums[i];
      }
    }
    if (nums[nums.length-1] != 13) {
      sum += nums[nums.length-1];
    }
    return sum;
  }

  public static int sum67(int[] nums) {
    int sum = 0;
    for(int i=0; i<nums.length; i++) {
      if (nums[i] == 6 ) {
        while(nums[i] != 7) {
          i++;
        }
      } else {
        sum += nums[i];
      }
    }
    return sum;
  }

  public static boolean has22(int[] nums) {
    for (int i=0; i<nums.length-1; i++) {
      if(nums[i] == 2) {
        if (nums[i+1] == 2) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean lucky13(int[] nums) {
    for (int i=0; i<nums.length; i++) {
      if (nums[i] == 1 || nums[i] == 3) {
        return false;
      }
    }
    return true;
  }

  public static boolean sum28(int[] nums) {
    int counter = 0;
    for (int i=0; i<nums.length; i++) {
      if (nums[i] == 2) {
        counter +=2;
      }
    }
    return counter == 8;
  }

  public static boolean more14(int[] nums) {
    int counterOne = 0;
    int counterFour = 0;
    for (int i=0; i<nums.length; i++) {
      if (nums[i] == 1) {
        counterOne++;
      }
      if(nums[i] == 4) {
        counterFour++;
      }
    }
    return counterOne > counterFour;
  }

  public static int[] fizzArray(int n) {
    int[] ret = new int[n];
    for(int i=0; i<ret.length; i++) {
      ret[i] = i;
    }
    return ret;
  }

  public static boolean only14(int[] nums) {
    for(int i=0; i<nums.length; i++) {
      if(nums[i] != 1 && nums[i] != 4) {
        return false;
      }
    }
    return true;
  }

  public static String[] fizzArray2(int n) {
    String[] ret = new String[n];
    for (int i=0; i<ret.length; i++) {
      ret[i] = String.valueOf(i);
    }
    return ret;
  }

  public static boolean no14(int[] nums) {
    int counterOne = 0;
    int counterFour = 0;
    for (int i=0; i<nums.length; i++) {
      if (nums[i] == 1) {
        counterOne++;
      }
      if (nums[i] == 4) {
        counterFour++;
      }
    }
    return (counterOne == 0) || (counterFour == 0);
  }

  public static void main(String[] args) {
    System.out.println(countEvens(new int[] {1,2,4,5,5,6}));
    System.out.println(bigDiff(new int[] {101,104,101,1000,1}));
    System.out.println(centeredAverage(new int[] {1002, 1, 7, 8, 9}));
    System.out.println(sum13(new int[] {1,2,3,13}));
    System.out.println(sum67(new int[] {1, 2, 3, 6, 1, 2, 7, 8}));
    System.out.println(has22(new int[] {1, 2, 2, 4, 5}));
    System.out.println(lucky13(new int[] {1,2,5,6,7}));
    System.out.println(sum28(new int[] {2,2,3,2,1}));
    System.out.println(more14(new int[] {1,2,1,1,1}));
    System.out.println(arrToString(fizzArray(7)));
    System.out.println(only14(new int[] {1,4,4,4,1}));
    System.out.println(arrToString(fizzArray2(4)));
    System.out.println(no14(new int[] {1,2,3,1}));
  }

}
