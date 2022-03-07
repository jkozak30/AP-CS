// Great, Nice Jingles: Julia Kozak, Gloria Lee, Nafiz Labib (Flopsy, Flounder, Martha)
// APCS
// HW71 -- Whut Dis.
// 2022-03-08
// time spent: 0.5hrs

/*
DISCO:
 - Step-by-step tracing is a good way of tracking each iteration.
 - This method can be used to partition only a portion of an array because it will only consider terms in the range [a, b].

QCC:
 - Could we iterate through each possible c value (or maybe do something like merge sort where we partition in half, then again in half, etc.) in order to sort the array?

q0: What does it do?
 - This program partitions the set into two sets of terms based on the value of index c, and in a given range of indices [a, b]. It checks if each value in that range is less than arr[c], moves it to the front if so, then swaps the value of arr[c] to the end of those.

q1: What is its Big-Oh runtime?
 - O(n), because it iterates through each value in the range [a, b] and does one action (swap/not swap) in each of those iterations.

*/

public class Mysterion {

  public static int[] partitionAtVal(int[] arr, int lo, int hi, int index) {
    int[] ret = new int[arr.length];

    int tracker = 0;
    for (int i : arr) {
      ret[tracker] = i;
      tracker++;
    }
    int valAt = ret[index];
    //
    ret[index] = ret[hi];
    ret[hi] = valAt;
    //
    int swapIndex=lo;
    for (int i=lo; i<hi; i++) {
      if (ret[i] < valAt) {
        int temp = ret[swapIndex];
        ret[swapIndex] = ret[i];
        ret[i] = temp;
        swapIndex++;
      }
    }
    //
    int temp = ret[hi];
    ret[hi] = ret[swapIndex];
    ret[swapIndex] = temp;

    return ret;
  }





  public static void main(String[] args) {
    int[] test = {3, 61, 10, 2, 5};
    int[] result1 = partitionAtVal(test, 0, 4, 2);
    int[] result2 = partitionAtVal(test, 1, 4, 3);
    int[] result3 = partitionAtVal(test, 3, 3, 3);
    int[] result4 = partitionAtVal(test, 4, 1, 1);
    int[] result5 = partitionAtVal(test, 0, 3, 4); //doesn't work
    for (int i : result1) {
      System.out.print(i + ", ");
    }
    System.out.println();
    for (int i : result2) {
      System.out.print(i + ", ");
    }
    System.out.println();
    for (int i : result3) {
      System.out.print(i + ", ");
    }
    System.out.println();
    for (int i : result4) {
      System.out.print(i + ", ");
    }
    System.out.println();
    for (int i : result5) {
      System.out.print(i + ", ");
    }
    System.out.println();
  }

}
