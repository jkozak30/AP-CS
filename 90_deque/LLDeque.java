//Under Pressure: Julia Kozak, Yat Long Chan, Anjini Katari
//APCS pd08
//HW90 - Swabbing the Deque
//2022-04-11M


import java.util.*;

public class LLDeque<T> implements Deque<T> {

  LinkedList<T> _deque;

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
    _deque.addFirst(x);
  }

  public void addLast(T x) {
    _deque.addLast(x);
  }
  //****

  //****
  public T remove() {
    return removeFirst();
  }
  public T removeFirst() {
    return _deque.removeFirst();
  }
  public T removeLast() {
    return _deque.removeLast();
  }
  //****

  //****
  public T peek() {
    return peekFirst();
  }
  public T peekFirst() {
    return _deque.peekFirst();
  }
  public T peekLast() {
    return _deque.peekLast();
  }

  public Iterator<T> iterator() {
    return _deque.iterator();
  }
  //****
}
