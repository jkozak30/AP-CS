//Under Pressure: Julia Kozak, Yat Long Chan, Anjini Katari
//APCS pd08
//HW90 - Swabbing the Deque
//2022-04-11M


import java.util.*;

public class LLDeque<T> implements Deque<T> {

  private LinkedList<T> _deque;

  public LLDeque() {
        _deque = new LinkedList<T>();
    }

    public T peekFirst() {
        if (isEmpty()) return null;
        return _deque.getFirst();
    }

    public T peekLast() {
        if (isEmpty()) return null;
        return _deque.getLast();
    }

    public boolean isEmpty() {
        return _deque.size() <= 0;
    }

    public void addFirst(T x) {
        _deque.addFirst(x);
    }

    public void addLast(T x) {
        _deque.addLast(x);
    }

    public T removeFirst() {
        return _deque.removeFirst();
    }

    public T removeLast() {
        return _deque.removeLast();
    }

    public T peek() {
        if (isEmpty()) return null;
        return _deque.getFirst();
    }

    public T remove() {
        return _deque.remove();
    }

    public boolean add(T x) {
        return _deque.add(x);
    }

    public Iterator<T> iterator() {
        return _deque.iterator();
    }

    public int size() {
        return _deque.size();
    }
}
