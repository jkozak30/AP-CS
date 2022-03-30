import java.util.*;

public class LLStack<PANCAKE> implements Stack<PANCAKE> {

  LinkedList<PANCAKE> _stack;
  int _stackSize;

  public LLStack () {
  _stack = new LinkedList<PANCAKE>();
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
