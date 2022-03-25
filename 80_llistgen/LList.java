// Under Pressure: Julia Kozak, Anjini Katari, Yat Long Chan
// APCS pd08
// HW78 -- Double Up
// 2022-03-17
// time spent: 0.5hrs
// KTS used: 2

/*
  DISCO:    - An object with methods/values referenced cannot be null itself, but its attributes
              can be set to null.
            - No edge cases (except adding to the front) are needed for add(index).
  QCC:      - Would it ever be useful to link the end back to _head?
  ALGO ADD: If the index being added to is 0, call add(newVal). If index == _size, add element to the end.
            Otherwise, create a newNode that will be added. Set a temporary reference, tmp, to _head, 
            and set it to the next node until it is at index-1. 
            Then, let tmp's next be newNode and newNode's previous be tmp,
             and do the same for the other pair including newNode. 
Increment _size.
  ALGO REM: If the index being removed is 0, then let the list start at _head's next, and set the
            previous node to null. Otherwise, create a reference, tmp, originally set to _head,
            and set it to the next node until it is at index-1. Then, set tmp's next node to the
            one that is two after it, then set its new next node's previous to tmp. Decrement _size.
*/

/*****************************************************
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 * new in v2: add-at-index, remove
 *****************************************************/

public class LList<T> implements List<T> //your List interface must be in same dir
{ 

  //instance vars
  private DLLNode<T> _head;
  private DLLNode<T> _tail;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _tail = null;
    _size = 0;
  }


  //--------------v  List interface methods  v--------------
    
  public boolean add( T newVal )
  {
    DLLNode<T> tmp = new DLLNode<T>( null, newVal, _head );
    if (_head != null) _head.setPrev(tmp);
    _head = tmp;
    if (_tail == null) _tail = tmp;
    _size++;
    return true;
  }

    
  public T get( int index )
  {
    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    T retVal;
    DLLNode<T> tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }


  public T set( int index, T newVal )
  {

    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    DLLNode<T> tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

    //store target node's cargo
    T oldVal = tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }
    

  //insert a node containing newVal at position index
  public void add( int index, T newVal ) {

    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    DLLNode<T> newNode = new DLLNode<T>( null, newVal, null );

    //if index==0, insert node before head node
    if ( index == 0 ) 
	    add( newVal );
    else if (index == _size)
      addLast(newVal);
    else {
	    DLLNode<T> tmp = _head; //create alias to head

	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ )
        tmp = tmp.getNext();

	    //insert new node
	    newNode.setNext( tmp.getNext() );
      newNode.setPrev(tmp);
      tmp.getNext().setPrev(newNode);
	    tmp.setNext( newNode );

	    //increment size attribute
	    _size++;
    }
  }


  //remove node at pos index, return its cargo
  public T remove( int index ) {

    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    T retVal;
    DLLNode<T> tmp = _head; //create alias to head

    //if index==0, remove head node
    if ( index == 0 ) {
	    //check target node's cargo hold
	    retVal = _head.getCargo();

	    //remove target node
	    _head = _head.getNext();
      if (_size > 1) _head.setPrev(null);
    }
    else {
	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ )
        tmp = tmp.getNext();

	    //check target node's cargo hold
	    retVal = tmp.getNext().getCargo();

	    //remove target node
      if (index != _size - 1) tmp.getNext().getNext().setPrev(tmp);
	    tmp.setNext( tmp.getNext().getNext() );
    }

    //decrement size attribute
    _size--;

    return retVal;
  }

  //--------------^  List interface methods  ^--------------

  public boolean addLast( T newVal )
  {
    DLLNode<T> tmp = new DLLNode<T>( _head, newVal, null );
    if (_tail != null) _tail.setNext(tmp);
    _tail = tmp;
    if (_head == null) _head = tmp;
    _size++;
    return true;
  }

  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    DLLNode<T> tmp = _head; //init tr
    while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }

}//end class LList
