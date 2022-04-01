//Under Pressure: Julia Kozak, Anjini Katari, Yat Long Chan
//APCS pd08
//HW86 -- What a Racket
//2022-04-01
//time spent: 0.6hrs

/*
  DISCO:
  - Writing the code was super ez once we figured out the algo
  - Once a ")" is reached, the algorithm will go back to the latest "(" and
    evaluate the expression between those two.
  QCC:
  - Which Stack implementation would be best?
*/

/***
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Split the string and push every character that isn't a closing parens.
 *   2. If you reach a closing parens, pop elements from your main stack into
 *      a separate stack that will be operated on, until you reach an open parens.
 *   3. Take the operation (top element of new stack) and call unload to evaluate
 *      that part of the expression, then push it to the main expression stack.
 *   4. This goes until each expression in parens is evaluated, so return the value
 *      remaining in your stack at the very end.
 *
 * STACK OF CHOICE: LLStack by Under Pressure
 * b/c if ALStack reaches max capacity in the array encapsulated in the AL, an O(n) op is required to expand the capacity.
 *     This doesn't happen with LL and adding nodes to head/tail.
 **/

public class Scheme
{
  /***
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   **/
  public static String evaluate( String expr )
  {
    String[] expression = expr.split("\\s+");
    Stack<String> expreStack = new LLStack<String>();
    Stack<String> numbers =  new LLStack<String>();

    for (int i=0; i<expression.length; i++) {

      if (!expression[i].equals(")")) {
        expreStack.push(expression[i]);
      } else {
        int op = 0;
        while (!expreStack.peekTop().equals("(")) {
          numbers.push(expreStack.pop());
        }
        if (numbers.peekTop().equals("+")) op = 1;
        if (numbers.peekTop().equals("-")) op = 2;
        if (numbers.pop().equals("*")) op = 3;
        expreStack.pop();

        expreStack.push(unload(op, numbers));
      }
    }

    return expreStack.peekTop();

  }//end evaluate()


  /***
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek(). //sorry
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   **/
  public static String unload( int op, Stack<String> numbers )
  {
    int ret = Integer.parseInt(numbers.pop());
    while (!numbers.isEmpty()) {
      if (op == 1) { ret += Integer.parseInt(numbers.pop()); }
      if (op == 2) { ret -= Integer.parseInt(numbers.pop()); }
      if (op == 3) { ret *= Integer.parseInt(numbers.pop()); }
    }

    return Integer.toString(ret);

  }//end unload()


  /*
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
  }
  catch( NumberFormatException e ) {
  return false;
  }
  }
  */


  //main method for testing
  public static void main( String[] args )
  {

    ///*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4
      //^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main()

}//end class Scheme
