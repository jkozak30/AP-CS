/***
 * class Stckr
 * SKELETON
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 **/

public class Stckr
{
  public static void main( String[] args )
  {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // USAGE: un-comment exactly 1 assignment below
    //Stack cakes = new ALStack(); //what is Z
    Stack cakes = new LLStack();

    //Stack<Integer> pans = new ALStack<Integer>();
    Stack<Integer> pans = new LLStack<Integer>();
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    System.out.println("adding elements to cakes");
    cakes.push(true);
    cakes.push(1);
    cakes.push("hello");
    cakes.push(2.0);
    System.out.print("top: ");
    System.out.println(cakes.peekTop());
    System.out.print("just removed: ");
    System.out.println(cakes.pop());
    System.out.print("now top: ");
    System.out.println(cakes.peekTop());
    System.out.println("removing ... ");
    while (!cakes.isEmpty())
      System.out.println(cakes.pop());


    System.out.println();
    System.out.println("adding elements to pans");
    pans.push(1);
    pans.push(2);
    pans.push(20000);
    pans.push(4);
    System.out.print("top: ");
    System.out.println(pans.peekTop());
    System.out.print("just removed: ");
    System.out.println(pans.pop());
    System.out.print("now top: ");
    System.out.println(pans.peekTop());
    System.out.println("removing ... ");
    while (!pans.isEmpty())
      System.out.println(pans.pop());

    //...

  }//end main

}//end class
