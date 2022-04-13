public interface Deque<T> {

    public boolean isEmpty();
    public int size();

    public void add(T x); //from last
    public void addFirst(T x);
    public void addLast(T x);

    public T remove(); //from first
    public T removeFirst();
    public T removeLast();

    public T peek(); //from first
    public T peekFirst();
    public T peekLast();
}
