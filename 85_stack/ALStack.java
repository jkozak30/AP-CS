import java.util.*;

public class ALStack<PANCAKE> implements Stack<PANCAKE> {

  ArrayList<PANCAKE> _stack;

  public ALStack () {
    _stack = new ArrayList<PANCAKE>();
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
