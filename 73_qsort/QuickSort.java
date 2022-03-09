//Under Pressure: Julia Kozak, Yat Long Chan, Anjini Katari
//APCS pd08
//HW72 -- QuickSort
//2022-03-09w
//time spent: 0.5h

/***
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): It relies on the helper method that also takes extra parameters hi, lo.
 * The helper will look at if hi has crossed lo, and if not, it will partition the set
 * (at the random pivot), then call itself again on the two ranges to the left and to
 * the right of the pivot. qsort(arr) will call the helper method on the entire range.
 *
 * 2a. Worst pivot choice and associated run time:
 * We have no way of knowing which pivot choice relative to hi, lo is best/worst if we
 * have no information on our data set, but if our pivot lands at one of the ends after
 * partition, it will result in the worst case, which is O(n^2) if every step proceeds
 * like this because there will be n iterations of a O(n) operation.
 *
 * 2b. Best pivot choice and associated run time:
 * If the pivot lands in the center each time, it will result in the best case, which is
 * O(nlog(n)) because you'll have ceil(log_2(n)) of O(n) operations.
 *
 * 3. Approach to handling duplicate values in array:
 * We don't have to treat them separately for sorting because given that one of the
 * duplicate values lands in the right position after partition, the others will
 * pivot around that and eventually land adjacent to it. (For ythSmallest, if we were
 * trying to find the yth smallest among the set of distinct values, it may just be
 * better to sort then iterate through.)
 **/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o )
  {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a )
  {
    for ( int o : a )
      System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d )
  {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
      tmp = d[i];
      swapPos = i + (int)( (d.length - i) * Math.random() );
      swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal )
  {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
      retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------




  /**
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   */
  public static void qsort( int[] d )
  {
    qsortHelper(d, 0, d.length-1);

  }

  //you may need a helper method...
  public static void qsortHelper(int[] d, int lo, int hi) {
    if (lo < hi) {
      int partition = Partition.partition(d, lo, hi);
      qsortHelper(d, lo, partition-1);
      qsortHelper(d, partition+1, hi);
    }
  }





  //main method for testing
  public static void main( String[] args )
  {
    ///*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)

    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    qsort( arr1 );
    System.out.println("arr1 after qsort: " );
    printArr(arr1);

    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;

    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


    ///*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)

    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);

    qsort( arr2 );
    System.out.println("arr2 after qsort: " );
    printArr(arr2);


    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );

    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);

    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);

    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);
  //  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class QuickSort
