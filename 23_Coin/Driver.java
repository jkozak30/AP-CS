/*
* Creative Name - Julia Kozak, Neil Lin (Flopsy, Hatch)
* APCS
* HW23 -- What Does Equality Look Like?
* 2021-10-22
*
* DISCO: Math.random() generates a random double from 0.0 to 1.0
*
*
* QCC: what does .toString() do, or how were we supposed to use it?
*
*/

/***
    driver for class Coin

    ~~~ SUGGESTED WORKFLOW: ~~~
    1. Compile this file and run. Note anything notable.
    2. Move the "TOP" line down, so that it is below the first statement.
    (emacs: with cursor at beginning of TOP line, C-k C-k, DOWN, DOWN, C-y)
    (your editor: ???)
    3. Compile and run again.
    4. Resolve errors one at a time until it works.
    5. Repeat 2-4 until TOP meets BOTTOM.
***/

public class Driver {

  public static void main( String[] args ) {

    //build Objects from blueprint specified by class Coin


    //test default constructor

      Coin mine = new Coin();

      //test 1st overloaded constructor
      Coin yours = new Coin( "quarter" );
      yours.reset("heads", 1.0);

      //test 2nd overloaded constructor
      Coin wayne = new Coin( "dollar", "heads" );

      //test toString() methods of each Coin
      System.out.println("mine: " + mine.toString());
      System.out.println("yours: " + yours.toString());
      System.out.println("wayne: " + wayne.toString());

      //test flip() method
      System.out.println("\nAfter flipping...");
      yours.flip();
      wayne.flip();
      System.out.println("yours: " + yours.toString());
      System.out.println("wayne: " + wayne.toString());

      //test equals() method
      if ( yours.equals(wayne) ) {
        System.out.println( "Matchee matchee!" );
      }
      else {
        System.out.println( "No match. Firestarter you can not be." );
      }
      yours.flip();
      wayne.flip();
      yours.flip();
      wayne.flip();
      yours.flip();
      wayne.flip();
      yours.flip();
      wayne.flip();
      yours.flip();
      wayne.flip();
      //print info
      System.out.println(yours.getFlipCtr() + "\n" + yours.getValue() + "\n" + yours.getHeadsCtr() + "\n" + yours.getTailsCtr());
      System.out.println(wayne.getFlipCtr() + "\n" + wayne.getValue() + "\n" + wayne.getHeadsCtr() + "\n" + wayne.getTailsCtr());




  }//end main()

}//end class
