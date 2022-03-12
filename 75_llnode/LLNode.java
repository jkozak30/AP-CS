/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class LLNode
{
  //instance vars
  private String cargo;
  private LLNode next;

  // constructor
  public LLNode( String value, LLNode next )
  {
    cargo = value;
    this.next = next;
  }


  //--------------v  ACCESSORS  v--------------
  public String getCargo()
  {
    return cargo;
  }

  public LLNode getNext()
  {
    return next;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public String setCargo( String newCargo )
  {
    String ret = cargo;
    this.cargo = newCargo;
    return ret;
  }

  public LLNode setNext( LLNode newNext )
  {
    LLNode ret = next;
    this.next = newNext;
    return ret;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString()
  {
    String ret = cargo;
    if (next != null) {
      ret += " ";
      ret += this.next.toString();
    }
    return ret;
  }


  //main method for testing
  public static void main( String[] args )
  {

    //Below is an exercise in creating a linked list...

    //Create a node
    LLNode first = new LLNode( "cat", null );

    //Create a new node after the first
    first.setNext( new LLNode( "dog", null ) );

    //Create a third node after the second
    first.getNext().setNext( new LLNode( "cow", null ) );

    /* A naive list traversal, has side effects.... ??
       while( first != null ) {
       System.out.print( first );
       first = first.getNext();
       }
       */
    //System.out.println(first.getNext());


    //Q: when head ptr moves to next node in list, what happens to the node it just left?
    // That node becomes null (first gets set to null and you can no longer reference it)

    //...so better: ?
    // create a new reference
    LLNode current = first;
    while (current != null) {
      System.out.println( current );
      current = current.getNext();
    }
    System.out.println(first);
    System.out.println(first.getNext());
    System.out.println(first.getNext().getNext());

  }//end main

}//end class LLNode
