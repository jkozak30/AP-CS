import java.util.*;

public class ArrayPriorityQueue implements PriorityQueue {

  private ArrayList<int[]> _queue;

  public ArrayPriorityQueue() {
    _queue = new ArrayList<>();
  }


  public void add( int obj, int x ) {
    int[] ret = new int[2];
    ret[0] = obj;
    ret[1] = x;
    _queue.add(ret);
  }

  public boolean isEmpty() {
    return _queue.size() <= 0;
  }

  public int peekMin() {
    int min = _queue.get(0)[1];
    int minIndex = 0;
    for (int i=1; i<_queue.size(); i++) {
      if (_queue.get(i)[1] < min) {
        min = _queue.get(i)[1];
        minIndex = i;
      }
    }
    return _queue.get(minIndex)[0];
  }

  public int removeMin() {
    int min = _queue.get(0)[1];
    int minIndex = 0;
    for (int i=1; i<_queue.size(); i++) {
      if (_queue.get(i)[1] < min) {
        min = _queue.get(i)[1];
        minIndex = i;
      }
    }
    int ret = _queue.get(minIndex)[0];
    _queue.remove(minIndex);
    return ret;
  }

  public static void main(String[] args) {
    ArrayPriorityQueue a = new ArrayPriorityQueue();
    a.add(7, 1);
  }
}
