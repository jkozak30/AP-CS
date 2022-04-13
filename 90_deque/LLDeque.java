import java.util.*;

public class LLDeque<T> implements Deque<T> {

  List<T> _deque;

  public LLDeque() {
    _deque = new LinkedList<T>();
  }

  public boolean isEmpty() {
    return _deque.size() <= 0;
  }

  public int size() {
    return _deque.size();
  }

  //****
  public void add(T x) {
    addLast(x);
  }

  public void addFirst(T x) {
    _deque.add(0, x);
  }

  public void addLast(T x) {
    _deque.add(x);
  }
  //****

  //****
  public T remove() {
    return removeFirst();
  }
  public T removeFirst() {
    return _deque.remove(0);
  }
  public T removeLast() {
    return _deque.remove(_deque.size()-1);
  }
  //****

  //****
  public T peek() {
    return peekFirst();
  }
  public T peekFirst() {
    return _deque.get(0);
  }
  public T peekLast() {
    return _deque.get(_deque.size()-1);
  }
  //****

  public static void main(String[] args) {
    Deque<Integer> due = new LLDeque<Integer>();

    for (int i=1; i<2049; i*=2) {
      due.add(i);
    }
    System.out.println("first: " + due.peek());
    System.out.println("same: " + due.peekFirst());
    System.out.println("last: " + due.peekLast());

    System.out.println("last removed: " + due.removeLast());
    System.out.println("new last: " + due.peekLast());

    while (!due.isEmpty()) {
      System.out.println(due.remove());
    }

    Deque que = new LLDeque();
    que.addFirst(true);
    que.addLast(3);
    que.addFirst("one");
    que.addLast(4.0);
    System.out.println();

    while (!que.isEmpty()) {
      if (que.size() >= 0) {
        System.out.println(que.removeLast());
      }
      if (que.size() >= 0) {
        System.out.println(que.removeFirst());
      }
    }


  }


  //****
}
