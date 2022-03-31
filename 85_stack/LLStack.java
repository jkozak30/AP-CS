import java.util.*;

public class LLStack<PANCAKE> implements Stack<PANCAKE> {

  LinkedList<PANCAKE> _stack;
  int _stackSize;

  public LLStack () {
  _stack = new LinkedList<PANCAKE>();
  }

  public boolean isEmpty() {
    return _stack.size() == 0;
  }

  public PANCAKE peekTop() {
    return _stack.get(_stack.size() - 1);
  }

  public PANCAKE pop() {
    return _stack.remove(_stack.size()-1);
  }

  public void push(PANCAKE x) {
    _stack.add(x);
  }


}
