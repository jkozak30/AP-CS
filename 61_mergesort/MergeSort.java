// Great, Nice Jingles: Julia Kozak, Nafiz Labib, Gloria Lee (Flopsy, Martha, Flounder)
// APCS pd08
// HW61: Instructions so Simple...
// 2022-02-09
// time spent: 0.5hrs

/***
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:

  ***/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
    int i = 0;
    int j = 0;
    int k = 0;
    int mergeSize = a.length + b.length;
    int[] ret = new int[mergeSize];
    while (i<mergeSize) {
      if (j < a.length && k < b.length) {
        if (a[j] > b[k]) {
          ret[i] = b[k];
          k++;
        } else {
          ret[i] = a[j];
          j++;
        }
      } else if (j >= a.length) {
        ret[i] = b[k];
        k++;
      } else {
        ret[i] = a[j];
        j++;
      }
      i++;
    }
    return ret;

  }//end merge()


  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort( int[] arr )
  {
    int[] ret;
    if (arr.length == 1) {
      return arr;
    } else {
      int[] temp1 = new int[arr.length / 2];
      int[] temp2 = new int[arr.length - arr.length / 2];
      for (int i=0; i<arr.length/2; i++) {
        temp1[i] = arr[i];
      }
      for (int i=arr.length/2; i<arr.length; i++) {
        temp2[i-arr.length/2] = arr[i];
      }
      int[] sorted1 = sort(temp1);
      int[] sorted2 = sort(temp2);
      ret = merge(sorted1, sorted2);
    }
    return ret;
  }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args )
  {
      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};

      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
      mess(arr3);
      printArray( arr3 );

      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );

      System.out.println("\nMerging arr4 and arr6: ");
      printArray( merge(arr4,arr6) );

      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );
  }//end main()

}//end class MergeSort
