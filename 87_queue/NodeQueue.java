//Under Pressure: Julia Kozak, Anjini Katari, Yat Long Chan
//APCS pd08
//HW87 -- The English Do Not Wait In Line for Soup
//2022-04-04
//time spent: 0.6hrs

/*
  DISCO:
  - We can include subclass Node that will have the same functionalities
    as an LLNode.
  - Adding elements at either the front or the end of your nodes makes no
    difference, as you'll have to traverse the nodes in one of either
    queue() or dequeue().
  QCC:
  - Any example problems using queues?
*/




public class NodeQueue<T> implements Queue<T> {

  private class Node {
    //instance vars
    private T cargo;
    private Node next;

    // constructor
    public Node( T value, Node next ) {
      cargo = value;
      this.next = next;
    }

    //--------------v  ACCESSORS  v--------------
    public T getCargo() { return cargo; }

    public Node getNext() { return next; }
    //--------------^  ACCESSORS  ^--------------

    //--------------v  MUTATORS  v--------------
    public T setCargo( T newCargo ) {
      T ret = cargo;
      this.cargo = newCargo;
      return ret;
    }

    public Node setNext( Node newNext ) {
      Node ret = next;
      this.next = newNext;
      return ret;
    }
    //--------------^  MUTATORS  ^--------------


  }//end class Node


  Node _front;
  int _size;

  public NodeQueue() {
    _front = new Node(null, null);
    _size = 0;
  }

  public T dequeue() {
    T ret = _front.getCargo();
    if (_front == null) return null;
    _front = _front.getNext();
    _size--;
    return ret;
  }

  public void enqueue(T x) {
    Node add = new Node(x, null);
    if (_size == 0) _front = add;
    else {
      Node current = _front;
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(add);
    }
    _size++;

  }

  public boolean isEmpty() {
    return _size == 0;
  }

  public T peekFront() {
    return _front.getCargo();
  }

  public static void main(String[] args) {


    NodeQueue<Integer> cue = new NodeQueue<Integer>();
    cue.enqueue(42063);
    cue.enqueue(9906);
    cue.enqueue(10101);
    cue.enqueue(60);
    cue.enqueue(2048);
    while (!cue.isEmpty()) {
      System.out.println(cue.peekFront());
      System.out.println(cue.dequeue());
    }



    NodeQueue que = new NodeQueue();
    que.enqueue("hello");
    que.enqueue(2020);
    que.enqueue(false);
    que.enqueue(1.2);
    while (!que.isEmpty()) {
      System.out.println(que.peekFront());
      System.out.println(que.dequeue());
    }
  }


}
