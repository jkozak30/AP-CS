//Under Pressure: Julia Kozak, Yat Long Chan, Anjini Katari
//APCS pd08
//HW89 -- Queue Two Ways
//2022-04-11M
//time spent: 0.4 hours

/*
DISCO
- Implementations for both AL and LLQ are the same but time complexities are different.

QCC
- Would it be better to make the var type LinkedList so that we can use addLast and removeFirst? 
- Is it fine to throw the IndexOutOfBoundsException of the List when dequeue() is run on an empty queue?
*/

import java.util.*;

public class ALQueue<T> implements Queue<T> {

    List<T> _queue;

    public ALQueue() {
        _queue = new ArrayList<T>();
    }

    public void enqueue(T x) {
        _queue.add(x);
    }

    public T dequeue() {
        return _queue.remove(0);
    }

    public boolean isEmpty() {
        return _queue.size() == 0;
    }

    public T peekFront() {
        return _queue.get(0);
    }

    public static void main(String[] args) {
        System.out.println("~~~~~~~~~~ Testing que ~~~~~~~~~~");
        Queue<Integer> que = new ALQueue<Integer>();
        que.enqueue(35);
        que.enqueue(70);
        que.enqueue(105);
        que.enqueue(140);
        que.enqueue(175);
        que.enqueue(210);
        System.out.println(que.peekFront());
        while (!que.isEmpty()) {
            System.out.println(que.dequeue());
        }

        System.out.println("~~~~~~~~~~ Testing cue ~~~~~~~~~~");
        Queue cue = new ALQueue();
        cue.enqueue(1);
        cue.enqueue(true);
        cue.enqueue("three");
        cue.enqueue(4.0);

        System.out.println(cue.peekFront());
        while(!cue.isEmpty()) {
            System.out.println(cue.dequeue());
        }
    }
}