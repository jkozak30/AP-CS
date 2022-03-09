//Under Pressure: Yat Long Chan, Anjini Katari, Julia Kozak
//apcs
// HW72 -- So So Fast
// 2022-03-08t
//time spent: 0.5 hr

/**
 * ALGO
 * Modify the partition method to return the final index at which the correctly placed value is swapped to.
 * The ythSmallestHelper method will take an array with hi and lo indices,
 * then call partition and store the value returned, pos.
 * If the returned value is our target (position y-1) or hi crosses lo,
 * it will return the value at that position. Otherwise, it will call itself again depending on the returned value,
 * calling again on the values below the partition for pos less than the target, and the values above otherwise.
 *
 *
 * BEST CASE
 * O(n)
 * Element at original pivot index is the yth smallest value.
 * Only one partition needs to be run.
 *
 * WORST CASE
 * O(n*n)
 * When pivot index isn't the yth smallest value.
 * Element at original pivot index is one of the extremes if the array were sorted.
 * In this case, the partitions will be uneven, with a majority of the elements on one side of the partition.
 * Then, partitions will have to be run for each smaller array.
 *
 * DISCO
 * Best and Worst cases significantly alter time complexity.
 * Splitting the array is similar to binary search.
 * Average case is O(n).
 *
 * QCC
 * What would be the optimal starting pivot?
 * In the case that 2 functions do the same task, would the recursive flavored function have a different time complexity than iterative one?
 * We always test the worst and best case scenarios, but do we care about the average ones?
 */

public class FastSelect {

  public static int partition(int[] arr, int lo, int hi, int index) {

    int val = arr[index];
    arr = swap(arr, hi, index);
    int swapIndex=lo;
    for (int i=lo; i<hi; i++) {
      if (arr[i] < val) {
        int temp = arr[swapIndex];
        arr = swap(arr, swapIndex, i);
        swapIndex++;
      }
    }
    //
    int temp = arr[hi];
    arr = swap(arr, hi, swapIndex);
    return swapIndex;

    //return arr;
  }

  public static int[] swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    return arr;
  }

  public static int ythSmallest(int[] arr, int y) {
    int[] tester = new int[arr.length];
    for (int i=0; i<arr.length; i++) {
      tester[i] = arr[i];
    }

    int tracker = -1;
    int hi=arr.length-1;
    int lo=0;
    while (tracker != y-1) {
      int s = partition(tester, lo, hi, hi);
      if (s < y-1) {
        lo = s+1;
      } else if (s > y-1) {
        hi = s-1;
      } else {
        tracker = y-1;
      }
    }
    return tester[tracker];
  }

  public static void main(String[] args) {
    int[] a1 = {1,7,3,12,5};
    System.out.println(ythSmallest(a1, 1)); // best case
    System.out.println(ythSmallest(a1, 4)); // worst case.
  }

}
