public class array1 {

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

  public static boolean firstLast6(int[] nums) {
    return (nums[0] == 6 || nums[nums.length-1] == 6);
  }

  public static boolean sameFirstLast(int[] nums) {
    if (nums.length != 0) {
      return (nums[0] == nums[nums.length-1]);
    } else {
      return false;
    }
  }

  public static int[] makePi() {
    int[] Pi = {3, 1, 4};
    return Pi;
  }

  public static boolean commonEnd(int[] a, int[] b) {
    return (a[0] == b[0] || a[a.length-1] == b[b.length-1]);
  }

  public static int sum3(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    return sum;
  }

  public static int[] rotateLeft3(int[] nums) {
    int firstTerm = nums[0];
    for(int i = 0; i < nums.length-1; i++) {
      nums[i] = nums[i+1];
    }
    nums[nums.length-1] = firstTerm;
    return nums;
  }

  public static int[] reverse3(int[] nums) {
    int[] oldNums = new int[3];
    for (int i=0; i<3; i++) {
      oldNums[i] = nums[i];
    }
    nums[0] = oldNums[2];
    nums[2] = oldNums[0];
    return nums;
  }

  public static int[] maxEnd3(int[] nums) {
    int max;
    if (nums[0] > nums[2]) {
      max = nums[0];
    } else {
      max = nums[2];
    }
    for (int i=0; i<nums.length; i++) {
      nums[i] = max;
    }
    return nums;
  }

  public static void main(String[] args) {
    System.out.println(firstLast6(new int[] {1,2,3,4}));
    System.out.println(sameFirstLast(new int[] {4,2,3,4}));
    System.out.println(arrToString(makePi()));
    System.out.println(commonEnd(new int[] {20,104,10,2021}, new int[] {20, 1, 1, 1, 1}));
    System.out.println(sum3(new int[] {1,2,3}));
    System.out.println(arrToString(rotateLeft3(new int[] {1,40,1020})));
    System.out.println(arrToString(reverse3(new int[] {1,4,6})));
    System.out.println(arrToString(maxEnd3(new int[] {345, 678, 123})));
  }
}
