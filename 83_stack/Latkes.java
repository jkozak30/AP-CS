// Under Pressure: Julia Kozak, Yat Long Chan, Anjini Katari
// APCS pd08
// HW83 -- Stacks on Stacks
// 2022-03-29
// time spent: 0.5hrs

/***
 * class Latkes
 * v1
 * SKELETON
 * Implements a stack of Strings using an encapsulated array
 **/

/***
    DISCO:
    _stack can expand like ArrayList (if the stack reaches capacity, it copies
    everything over to a larger array).
    In a stack, you can only access/operate on the last element added.

    QCC:
    Should the index of each newly added element always be 0? (ie does stack add to 
    the front of the array, or can we keep adding/removing from the end to increase 
    efficiency?)
    Can java stacks be typecasted as list types (ex. if you wanted to access any element,
    could you typecast as an array/ArrayList)?
 **/


public class Latkes
{
  private String [] _stack;
  private int _stackSize;


  //constructor
  public Latkes( int initCapacity )
  {
    _stack = new String[initCapacity];
    _stackSize = 0;
  }// O(1)


  //means of insertion
  public void push( String s )
  {
    if (isFull()) {
      String[] _newStack = new String[_stackSize * 2];
      for (int i=0; i<_stackSize; i++) {
        _newStack[i] = _stack[i];
      }
      _stack = _newStack;
    }
    _stack[_stackSize] = s;
    _stackSize++;
  }// O(n)


  //means of removal
  public String pop( )
  {
    if (isEmpty()) return null;
    String ret = _stack[_stackSize-1];
    _stack[_stackSize-1] = null;
    _stackSize--;
    return ret;
  }// O(1)


  //chk for emptiness
  public boolean isEmpty()
  {
    return _stackSize == 0;
  }// O(1)


  //chk for fullness
  public boolean isFull()
  {
    return _stackSize == _stack.length;
  }// O(1)


  //main method for testing
  public static void main( String[] args )
  {
    ///*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

    Latkes tastyStack = new Latkes(10);

    tastyStack.push("aoo");
    tastyStack.push("boo");
    tastyStack.push("coo");
    tastyStack.push("doo");
    tastyStack.push("eoo");
    tastyStack.push("foo");
    tastyStack.push("goo");
    tastyStack.push("hoo");
    tastyStack.push("ioo");
    tastyStack.push("joo");
    tastyStack.push("coocoo");
    tastyStack.push("cachoo");

    //cachoo
    System.out.println( tastyStack.pop() );
    //coocoo
    System.out.println( tastyStack.pop() );
    //joo
    System.out.println( tastyStack.pop() );
    //ioo
    System.out.println( tastyStack.pop() );
    //hoo
    System.out.println( tastyStack.pop() );
    //goo
    System.out.println( tastyStack.pop() );
    //foo
    System.out.println( tastyStack.pop() );
    //eoo
    System.out.println( tastyStack.pop() );
    //doo
    System.out.println( tastyStack.pop() );
    //coo
    System.out.println( tastyStack.pop() );
    //boo
    System.out.println( tastyStack.pop() );
    //aoo
    System.out.println( tastyStack.pop() );

    //stack empty by now; SOP(null)
    System.out.println( tastyStack.pop() );
      //^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main()

}//end class Latkes
