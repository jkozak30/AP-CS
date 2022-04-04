/***
 * class RQueue
 * SKELETON
 * A node-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 **/


public class RQueue<T> implements Queue<T>
{
  //instance variables
  private LLNode<T> _front, _end;
  private int _size;


  // default constructor creates an empty queue
  public RQueue()
  {
    _front = _end = null;
    _size = 0;
  }


  public void enqueue( T enQVal )
  {
    if ( isEmpty() ) {
      _front = _end = new LLNode<T>( enQVal, null );
    }
    else {
      _end.setNext( new LLNode<T>( enQVal, null ) );
      _end = _end.getNext();
    }
    _size++;
    System.out.println("enqueued " + enQVal);
  }//O(1)


  // remove and return thing at front of queue
  // assume _queue ! empty
  public T dequeue()
  {
    T retVal = _front.getCargo();
    _front = _front.getNext();

    if ( _front == null ) //just moved past last node
      _end = null;      //update _end to reflect emptiness

    _size--;

    return retVal;
  }//O(1)


  public T peekFront()
  {
    return _front.getCargo();
  }//O(1)


  /***
   * void sample() -- a means of "shuffling" the queue
   * Algo:
   *   < YOUR SUCCINCT SUMMARY HERE >
   **/
  public void sample()
  {
    LLNode[] shuffler = new LLNode[_size];
    LLNode current = _front;
    for (int i=0; i<_size; i++) {
      shuffler[i] = current;
      current = current.getNext();
    }
    for (int i=0; i<_size; i++) {
      int swap = (int)(Math.random() * _size);
      LLNode temp = shuffler[i];
      shuffler[i] = shuffler[swap];
      shuffler[swap] = temp;
    }
    for (int i=0; i<_size-1; i++) {
      shuffler[i].setNext(shuffler[i+1]);
    }
    shuffler[_size-1].setNext(null);
    _front = shuffler[0];
    _end = shuffler[_size-1];
  }//O(?)


  public boolean isEmpty()
  {
    return _front == null;
  } //O(?)


  // print each node, separated by spaces
  public String toString()
  {
    String retStr = "FRONT :: ";
    LLNode<T> tmp = _front; //init tr
    while( tmp != null ) {
      retStr += tmp.getCargo() + " ";
      tmp = tmp.getNext();
    }
    retStr += " :: END";
    return retStr;
  }



  //main method for testing
  public static void main( String[] args )
  {

      ///*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

    Queue<String> PirateQueue = new RQueue<String>();
    System.out.println("init: ");
    System.out.println(PirateQueue);

    System.out.println("\nnow enqueuing...");
    PirateQueue.enqueue("Dread");
    System.out.println(PirateQueue);
    PirateQueue.enqueue("Pirate");
    PirateQueue.enqueue("Roberts");
    PirateQueue.enqueue("Blackbeard");
    PirateQueue.enqueue("Peter");
    PirateQueue.enqueue("Stuyvesant");

    System.out.println("\nnow testing toString()...");
    System.out.println( PirateQueue ); //for testing toString()...

    System.out.println("\nnow dequeuing...");
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );

    System.out.println("\nnow dequeuing fr empty queue...\n" +
                       "(expect NPE)\n");
    //System.out.println( PirateQueue.dequeue() );

    RQueue<Integer> Que = new RQueue<Integer>();

    Que.enqueue(20);
    Que.enqueue(111111);
    Que.enqueue(200);
    Que.enqueue(210);
    Que.enqueue(230);
    Que.enqueue(2048);
    Que.enqueue(2);
    System.out.println(Que);
    Que.sample();
    System.out.println(Que);

      //^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue
