// Under Pressure: Julia Kozak, Yat Long Chan, Anjini Katari
// APCS pd08
// HW84 -- Stack: What Is It Good For?
// 2022-03-30
// time spent: 0.5hrs

/*
  DISCO:
  - Stacks can keep track of the last item you're looking for (ex. in
    matching parens).
  - pop() strictly removes an item so that you can access it, and peek()
    will remove and replace it so you can access it.

  QCC:
  - Can we (will we) generically type stacks?
  - Can stacks be used in recursive backtracking?

*/

/***
 * class LatKtS
 * SKELETON
 * driver class for Latkes
 * Uses a stack to reverse a text string, check for sets of matching parens.
 **/

public class LatKtS
{

  /***
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **/
  public static String flip( String s )
  {
    Latkes stack = new Latkes(s.length());

    for (int i=0; i<s.length(); i++)
      stack.push(s.substring(i, i+1));

    String ret = "";
    while (!stack.isEmpty()) ret += stack.pop();

    return ret;
  }


  /***
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **/
  public static boolean allMatched( String s )
  {
    if (s.length() == 0) return true;

    Latkes stack = new Latkes(s.length());
    for (int i=0; i<s.length(); i++) {
      String current = s.substring(i, i+1);

      if (isOpen(current)) { stack.push(current); }
      else {
        String innermost = stack.pop(); // or peek
        if (innermost == null) return false;
        if (!sameType(innermost, current)) return false;
      }

    }
    return stack.isEmpty();
  }

  //helper methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static boolean isOpen(String br) {
    if (br.equals("{") || br.equals("[") || br.equals("(")) return true;
    return false;
  }

  //open br, closed br
  public static boolean sameType(String o, String c) {
    if (o.equals("{") && c.equals("}")) return true;
    if (o.equals("[") && c.equals("]")) return true;
    if (o.equals("(") && c.equals(")")) return true;
    return false;
  }

  //end helper methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  //main method to test
  public static void main( String[] args )
  {
    ///*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
    System.out.println(flip("stressed"));
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    //  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class
