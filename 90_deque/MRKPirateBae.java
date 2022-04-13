//Under Pressure: Julia Kozak, Yat Long Chan, Anjini Katari
//APCS pd08
//HW90 - Swabbing the Deque
//2022-04-11M
import java.util.*;

public class MRKPirateBae {

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
    System.out.println();

    System.out.println("testing remove/add first/last (expected 4.0 one 3 true): ");
    Deque que = new LLDeque();
    que.addFirst(true);
    que.addLast(3);
    que.addFirst("one");
    que.addLast(4.0);

    while (!que.isEmpty()) {
      if (que.size() >= 0) {
        System.out.println(que.removeLast());
      }
      if (que.size() >= 0) {
        System.out.println(que.removeFirst());
      }
    }

    System.out.println();

    System.out.println("testing iterator: ");

  Deque<Integer> dq = new LLDeque<Integer>();
  for (int i=1; i<2049; i*=2) {
    dq.add(i);
  }

  Iterator<Integer> it = dq.iterator();

  while(it.hasNext()) {
    int next = it.next();
    if (next % 5 == 2) {
      it.remove();
    }
  }

  for (Integer i : dq) {
    System.out.println(i);
  }

  }


}
