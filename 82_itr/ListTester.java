/***
 * class ListTester
 * ...for putting your LList through its paces
 *
 * Assumes local List.java (interface),
 *  overriding List interface from standard Java library
 **/

public class ListTester
{
  public static void main( String[] args )
  {
    LList bob = new LList();
    LList<String> hi = new LList<String>();
    LList<Integer> hello = new LList<Integer>();
    bob.add(1);
    bob.add("hi");
    hi.add("hi");
    hi.add("bye");
    hello.add(1);
    hello.add(2);

    System.out.println("Testing generic LList");
    System.out.println(bob);
    bob.addLast(0.5);
    System.out.println(bob);
    bob.remove(0);
    System.out.println(bob);

    System.out.println("Testing String LList");    
    System.out.println(hi);
    hi.addLast("woah");
    hi.remove(1);
    System.out.println(hi);

    System.out.println("Testing Integer LList");
    System.out.println(hello);
    hello.addLast(3);
    System.out.println(hello);
    hello.remove(2);
    System.out.println(hello);
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class
