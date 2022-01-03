// Team Orange Marshmallows: Julia Kozak, Diana Akhmedova, Nina Jiang (Duckies: Flopsy, Ajax, Miss Alpaca)
// APCS pd08
// HW51 -- implementing bubblesort
// 2022-01-04t
// time spent: 0.5 hrs

/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 *
 * ALGO: For bubbleSortV, our method first passes through the ArrayList from the right, checking if the last pair is in increasing order, and swapping the two values if not. It repeats this for the second to last pair, then third to last, and so on. After this first pass, it will run through again, but since the value at index 0 is guaranteed to be in the correct position, it will cut short before the last comparison. It will repeat this over and over, each time comparing one less pair from the left. It also will not check the final last pair, as that is guaranteed to be correct.
 *       For bubbleSort, our method first adds the first value of the input ArrayList to the ArrayList that is to be returned. For each next value in the input ArrayList, the method checks for the first element in the current output ArrayList that is greater than the given value, and adds the value right before it (the invariant of increasing order is maintained through adding). If it does not find one, the value is added to the end. Then, the output ArrayList is returned as the sorted version of the input ArrayList.
 *
 * DISCO: We can use the size, add, and set methods of ArrayLists to return an element of an ArrayList and add or change values in a desired place.
 *        Comparables should be typecasted as ints or used with compareTo to compare their values, rather than using integer relational operators.
 *
 * QCC: Are we meant to get errors when setting "glen" and "coco" as new ArrayLists when testing bubbleSort in the main method, after they have already been declared for testing bubbleSortV?
 *
 * q0: If a pass requires no swaps, what do you know?
 * a0: This means that the array is already in increasing order.
 * q1: After pass p, what do you know?
 * a1: After pass p, we know that the first p values are correct.
 * q2: How many passes are necessary to completely sort?
 * a2: Th number of passes needed to completely sort is p - 1 passes.
 *
 ******************************/

import java.util.ArrayList;
@SuppressWarnings("unchecked")

public class BubbleSort
{

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond:  lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
      //     offset + rand int on interval [lo,hi]
      retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
      size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al )
  {
    int randomIndex;
    //setup for traversal fr right to left
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void bubbleSortV( ArrayList<Comparable> data )
  {
    for(int i = 0; i < data.size()-1; i++) {
    	for(int j = data.size() - 1; j > i; j--){
    		if((int)data.get(j) < (int)data.get(j - 1)) {
          int temp = (int)data.get(j);
          data.set(j, data.get(j - 1));
          data.set(j-1, temp);
    		}
    	}
    }
  }


  // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
  {
    ArrayList ans = new ArrayList<Comparable>();
    ans.add(input.get(0));
    for (int j=1; j<input.size(); j++) {
      for (int i=0; i<ans.size(); i++) {
        if ((int)ans.get(i) >= (int)input.get(j)) {
          ans.add(i, input.get(j));
          break;
        }
      }
      if ((int)input.get(j) > (int)ans.get(ans.size()-1)) {
        ans.add(input.get(j));
      }
    }
    return ans;
  }


  public static void main( String [] args )
  {

      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      bubbleSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      bubbleSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );


      /*
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = bubbleSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n"
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = bubbleSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n"
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      System.out.println( coco );
      */

  }//end main

}//end class BubbleSort
