/*
* Creative Name - Julia Kozak, Neil Lin (Flopsy, Hatch)
* APCS
* HW24 -- Get It While You Can
* 2021-10-26
*
* DISCO: while loops can run a certain set of actions until a certain condition>
* QCC: == seemed to work for string equality, do we have to use .equals() ?
* POST-v0 MODS: equals is now a void method that looks at whether the up faces >
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

  public static void flipXY(Coin notOther, Coin other) {
    while (notOther.getMatchCtr() < 65536 || notOther.getMatchCtr() % 2005 != 0) {
      other.flip();
      notOther.flip();
      notOther.equals(other);
    }
  }
  public static void main( String[] args ) {
    Coin me = new Coin();
    Coin you = new Coin();

    flipXY(me, you);
    System.out.println(me.getMatchCtr()); //66165
    System.out.println(me.getFlipCtr());
  }//end main()

}//end class
