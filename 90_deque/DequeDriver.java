//Under Pressure: Julia Kozak, Yat Long Chan, Anjini Katari
//APCS pd08
//HW90 - Swabbing the Deque
//2022-04-11M

public class DequeDriver {

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
}
