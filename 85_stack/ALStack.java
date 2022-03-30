import java.util.*;

public class ALStack<PANCAKE> implements Stack<PANCAKE> {

  ArrayList<PANCAKE> _stack;
  int _stackSize;

  public ALStack () {
    _stack = new ArrayList<PANCAKE>();
    _stackSize = 0;
  }

  public boolean isEmpty() {
    return _stackSize == 0;
  }

  public PANCAKE peekTop() {
    if (isEmpty()) return null;
    return _stack.get(_stackSize - 1);
  }

  public PANCAKE pop() {
    if (isEmpty()) return null;
    _stackSize--;
    return _stack.get(_stackSize);
  }

  public void push(PANCAKE x) {
    if (_stack.size() == _stackSize) _stack.add(x);
    _stack.set(_stackSize, x);
    _stackSize++;
  }

}
