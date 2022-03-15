// Under Pressure: Julia Kozak, Yat Long Chan, Anjini Katari
// APCS pd08
// HW77 -- Insert|Remove
// 2022-03-16
// time spent: 0.6hrs
// KTS used: 2

/*
  DISCO:    - Objects can be redefined in terms of themselves (ex. for add(newVal), you don't have
            to create a temp and _head can be redefined in one line)
            - We need to consider cases for adding the value at the first index separately in add-
            at-index
            - add(index) appends the new value to the front

  QCC:      - Is there any way to work around NullPointerExceptions without creating a separate case?

  algo add: If the index being added at is 0, call add(newVal). Otherwise, set LLNode temp as a new
            reference to _head, and set it to the next node until it is at position index-1. Then
            let temp direct to a new node with the newVal as its cargo, and let that new node direct
            to the rest of the list. Lastly, increment _size.

  algo rem: If the _size is 1, reset the _head to null and decrement _size. Otherwise, create a new
            reference to _head, temp, and set it to each next node until it is at position index-1.
            Set the next node for temp to the node two ahead of it, and decrement _size.

*/



/***
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 **/

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private LLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null;
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  /*
  public boolean add( String newVal )
  {
    if (_head == null) {
      _head = new LLNode(newVal, null);
    } else {

      LLNode temp = _head;
      while (temp.getNext() != null) {
        temp = temp.getNext();
      }
      temp.setNext( new LLNode(newVal, null) );

    }
    _size++;
    return true;
  }
  */



  public boolean add( String newVal ) {
    _head = new LLNode(newVal, _head);
    _size++;
    return true;
  }

  public void add( int index, String newVal ) {
    if ( index < 0 || index > size() )
      throw new IndexOutOfBoundsException();

    if (index == 0) {

      add(newVal);

    } else {

      int ctr = 0;
      LLNode temp = _head;
      while (ctr < index-1) {
        temp = temp.getNext();
        ctr++;
      }
      _size++;
      temp.setNext( new LLNode(newVal, temp.getNext()) );
      
    }


  }

  public String remove( int index ) {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    if (_size == 1) {
      String ret = _head.getCargo();
      _head = null;

      _size--;
      return ret;
    } else {
      LLNode temp = _head;
      int ctr = 0;
      while (ctr < index-1) {
        temp = temp.getNext();
        ctr++;
      }



      String ret = temp.getNext().getCargo();
      temp.setNext(temp.getNext().getNext());
      _size--;
      return ret;
    }



  }



  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    int ctr = 0;
    LLNode temp = _head;
    while (ctr < index) {
      temp = temp.getNext();
      ctr++;
    }
    return temp.getCargo();
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    int ctr = 0;
    LLNode temp = _head;
    while (ctr < index) {
      temp = temp.getNext();
      ctr++;
    }
    String ret = temp.getCargo();
    temp.setCargo(newVal);
    return ret;

  }


  //return number of nodes in list
  public int size()
  {
    return _size;
  }

  //--------------^  List interface methods  ^--------------



  // override inherited toString
  public String toString()
  {
    String ret = "[ ";
    LLNode temp = _head;
    while (temp != null) {
      ret += temp.getCargo() + " ";
      temp = temp.getNext();
    }
    ret += "]";
    return ret;
  }


  //main method for testing
  public static void main( String[] args )
  {
    ///*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    LList james = new LList();
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

    System.out.println( james );
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    james.remove(1);
    System.out.println( james );
    james.add(1, "got");
    System.out.println( james );
    while (james.size() > 0) {
      james.remove(james.size()-1);
      System.out.println(james);
    }
    james.add("beat");
    james.add("a");
    james.add("got");
    james.add(0, "I");


    System.out.println(james);
    while (james.size() > 0) {
      james.remove(0);
      System.out.println(james);
    }

    LList last = new LList();
    last.add("plefohev");
  }

}//end class LList
